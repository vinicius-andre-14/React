import React, { Component } from 'react';
import { Button, Container, Form, Row } from 'react-bootstrap';
import LendaServices from '../Servicos/LendaServices';

class CreateUpdateLenda extends Component {

    constructor (props){
        super(props);

        this.state={
            id_Lenda: this.props.match.params.id,
            nome: "",
            tipo: "",
            kills: "",
            nroSkins: ""
        };
        this.changeNomeHandler = this.changeNomeHandler.bind(this);
        this.changeTipoHandler = this.changeTipoHandler.bind(this);
        this.changeKillsHandler = this.changeKillsHandler.bind(this);
        this.changeNroSkinsHandler = this.changeNroSkinsHandler.bind(this);
        this.novaLenda = this.salvarLenda.bind(this);
    }

    componentDidMount(){
        if(this.state.id_Lenda == "/adduser"){
            return false;
        } else {
            return LendaServices.getLendaById(this.state.id_Lenda).then(
                (res) => {
                    let lenda = res.data;
                    this.setState({
                        nome: lenda.nome,
                        tipo: lenda.tipo,
                        kills: lenda.kills,
                        nroSkins: lenda.nroSkins});
                });
        }
    }

    changeNomeHandler(event){
        this.setState({nome : event.target.value})
    }
    changeTipoHandler(event){
        this.setState({tipo : event.target.value})
    }
    changeKillsHandler(event){
        this.setState({kills : event.target.value})
    }
    changeNroSkinsHandler(event){
        this.setState({nroSkins : event.target.value})
    }

    cancelar(){
        this.props.history.push("/lenda");
    }

    salvarLenda = (e) => {
        let lenda = {
            nome : this.state.nome,
            tipo : this.state.tipo,
            kills : this.state.kills,
            nroSkins : this.state.nroSkins
        }
        if(this.state.id_Lenda == "_add"){
                lenda.id_Lenda = "";
                LendaServices.createLenda(lenda).then(
                    (res)=>{
                        alert(res.data);
                    }
                )
            } else {
                lenda.id_Lenda = this.state.id_Lenda;
                LendaServices.editLenda(lenda).then(
                   (res) =>{console.log(res.data)}
                );
            }
            this.props.history.push("/lenda")
        }    

    render() {
        return (
            <Container>
                <Row className="justify-content-md-center">
                    <h1>Cadastro de lendas</h1>
                </Row>
                <Form>

                <Form.Group className="mb-3" controlId="nome">
                    <Form.Control type="text" placeholder="Nome" value={this.state.nome} onChange={this.changeNomeHandler}/>
                    <Form.Text className="text-muted">
                    Nome da Lenda
                    </Form.Text>
                </Form.Group>

                
                <Form.Group className="mb-3" controlId="tipo">                    
                    <Form.Control type="text" placeholder="tipo" value={this.state.tipo} onChange={this.changeTipoHandler}/>
                    <Form.Text className="text-muted">
                    Tipo da Lenda
                    </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="kills">
                    <Form.Control type="text" placeholder="Kills" value={this.state.kills} onChange={this.changeKillsHandler}/>
                    <Form.Text className="text-muted">
                    Número de kills
                    </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="nroSkins">
                    <Form.Control type="text" placeholder="nroSkins" value={this.state.nroSkins} onChange={this.changeNroSkinsHandler}/>
                    <Form.Text className="text-muted">
                    Número de skins
                    </Form.Text>
                </Form.Group>
                <Button variant="primary" onClick={this.cancelar.bind(this)}>Cancelar</Button>
                <a>   </a>
                <Button variant="success" onClick={this.salvarLenda}>Cadastrar</Button>
                </Form>
            </Container>
        );
    }
}

export default CreateUpdateLenda;