/**
 * ---------------------------------------------- Documentacao preliminar
 * Classe Pessoa
 * <p>
 * Atributos:
 * -ID
 * -Nome
 * -Telefone
 * -Tipo
 * -Email
 * -Dia do aniversario
 * -Mes do aniversario
 * -Ano do aniversario
 */

package com.person.bernardo.myperson;

public abstract class Pessoa {
    private static int id;
    private static String nome;
    private static String telefone;
    private static String tipo;
    private static String email;
    private static int dia;
    private static int mes;
    private static int ano;

    //constructor
    public Pessoa(int id, String nome, String telefone, String tipo, String email, int dia, int mes, int ano) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.email = email;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    //getters
    public static int getId() {
        return id;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getDia(String aniversario) {
        // XX/XX/XXXX
        int dia = Integer.parseInt(aniversario.substring(0, 2));
        return (dia);
    }

    public static int getMes(String aniversario) {
        // XX/XX/XXXX
        int mes = Integer.parseInt(aniversario.substring(3, 5));
        // decrementando
        return (mes - 1);
    }

    public static int getYear(String aniversario) {
        // XX/XX/XXXX
        int year = Integer.parseInt(aniversario.substring(6, 9));
        // decrementando
        return (year);
    }

    public static int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}