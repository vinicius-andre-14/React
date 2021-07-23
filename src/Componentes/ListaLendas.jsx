import React, { Component } from 'react';
import { Button, Container, Row, Table } from 'react-bootstrap';
import LendaServices from '../Servicos/LendaServices';

class ListaLendas extends Component {

    constructor (props){
        super(props);
        this.state={
            lendas:[]
        }

        this.voltar = this.voltar.bind(this);
        this.novaLenda = this.novaLenda.bind(this);
        this.editar = this.editar.bind(this);
        this.excluir = this.excluir.bind(this);
    }

    componentDidMount(){
        this.getLendas();
    }

    getLendas(){
        LendaServices.getLenda().then(
            (resposta) =>
                this.setState({lendas:resposta.data})
        );
    }

    voltar(){
        this.props.history.push("/");
    }

    excluir(id_Lenda){
        LendaServices.deleteLenda(id_Lenda).then(
            res => { 
                alert(res.data);
                this.getLendas();
            }    
        );
    }

    editar(id_Lenda){
        this.props.history.push("/lendas/"+id_Lenda);
    }

    novaLenda(){
        this.props.history.push("/lendas/_add");
    }

    render() {
        return (
            <Container>
                <Row>
                <h1>Lendas</h1>
                </Row>
                <Row>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    Nome
                                </th>
                                <th>
                                    Tipo
                                </th>
                                <th>
                                    Kills
                                </th>
                                <th>
                                    Skins
                                </th>
                                <th>
                                    Ações
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.lendas.map(
                                    lenda =>
                                    <tr key={lenda.id_Lenda}>
                                        <td>
                                            {lenda.id_Lenda}
                                        </td>
                                        <td>
                                            {lenda.nome}
                                        </td>
                                        <td>
                                            {lenda.tipo}
                                        </td>
                                        <td>
                                            {lenda.kills}
                                        </td>
                                        <td>
                                            {lenda.nroSkins}
                                        </td>
                                        <td>
                                        <Button variant="warning" onClick={()=>this.editar(lenda.id_Lenda)}>Editar</Button>
                                        <Button variant="danger" onClick={()=>this.excluir(lenda.id_Lenda)}>Excluir</Button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </Table>
                </Row>
                <Row>
                    <Container>
                    <Button variant="link" onClick={this.voltar}>Cancelar</Button>
                    <Button variant="primary" onClick={this.novaLenda}>Nova Lenda</Button>
                    </Container>
                </Row>
            </Container>
        );
    }
}

export default ListaLendas;