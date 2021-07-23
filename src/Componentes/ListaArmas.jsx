import React, { Component } from 'react';
import { Button, Container, Row, Table } from 'react-bootstrap';
import ArmasServices from '../Servicos/ArmasServices';

class ListaArmas extends Component {

    constructor (props){
        super(props);
        this.state={
            armas:[]
        }

        this.voltar = this.voltar.bind(this);
        this.novaLenda = this.novaArma.bind(this);
        this.editar = this.editar2.bind(this);
        this.excluir = this.excluir2.bind(this);
    }

    componentDidMount(){
        this.getArma();
    }

    getArma(){
        ArmasServices.getArma().then(
            (resposta) =>
                this.setState({armas:resposta.data})
        );
    }

    voltar(){
        this.props.history.push("/");
    }

    excluir2(Id_Arma){
        ArmasServices.deleteArma(Id_Arma).then(
            res => { 
                alert(res.data);
                this.getArma();
            }    
        );
    }

    editar2(Id_Arma){
        this.props.history.push("/armas/"+Id_Arma);
    }

    novaArma(){
        this.props.history.push("/armas/_add");
    }

    render() {
        return (
            <Container>
                <Row>
                <h1>Armas</h1>
                </Row>
                <Row>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>
                                    Nome
                                </th>
                                <th>
                                    Tipo
                                </th>
                                <th>
                                    munição
                                </th>
                                <th>
                                    Skins
                                </th>
                                <th>
                                    Dano
                                </th>
                                <th>
                                    Dano Hs
                                </th>
                                <th>
                                    Ações
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.armas.map(
                                    arma =>
                                    <tr key={arma.Id_Arma}>
                                        <td>
                                            {arma.nome}
                                        </td>
                                        <td>
                                            {arma.tipo}
                                        </td>
                                        <td>
                                            {arma.municao}
                                        </td>
                                        <td>
                                            {arma.nroSkins}
                                        </td>
                                        <td>
                                            {arma.dano}
                                        </td>
                                        <td>
                                            {arma.danohs}
                                        </td>
                                        <td>
                                        <Button variant="warning" onClick={()=>this.editar2(arma.Id_Arma)}>Editar</Button>
                                        <Button variant="danger" onClick={()=>this.excluir2(arma.Id_Arma)}>Excluir</Button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </Table>
                </Row>
                <Row >
                    <Button variant="link" onClick={this.voltar}>Cancelar</Button>
                    <Button variant="primary" onClick={this.novaArma}>Nova Arma</Button>

                </Row>
            </Container>
        );
    }
}

export default ListaArmas;