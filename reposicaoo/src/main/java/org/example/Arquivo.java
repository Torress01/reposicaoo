package org.example;

import java.util.ArrayList;

class Arquivo {
    ArrayList<Cliente> clientes = new ArrayList<>();

    public void escrever(Cliente c) {
        clientes.add(c);
    }

    public ArrayList<Cliente> ler() {
        return clientes;
    }
}
