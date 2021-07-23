import React, { Component } from 'react';
import {Navbar, Nav} from 'react-bootstrap';

class barraNavegacao extends Component {
    render() {
        return (
            <header>

                 <Navbar bg="dark" variant="dark">
                        <Navbar.Brand href="/">Home</Navbar.Brand>
                            <Nav className="me-auto">
                            <Nav.Link href="/lenda">Lendas</Nav.Link>

                        </Nav>
                        

                </Navbar>
            </header>
        );
    }
}

export default barraNavegacao;