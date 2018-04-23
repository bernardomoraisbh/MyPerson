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

import java.io.Serializable;

public class Pessoa implements Serializable {
    private static int id;
    private static String nome;
    private static String telefone;
    private static String tipo;
    private static String email;
    private static String endereco;
    private static int dia;
    private static int mes;
    private static int ano;
    private static String facebook;
    private static String LinkedIn;
    private static String Instagram;
    private static String Youtube;
    private static String Spotify;
    private static String Twitter;
    private static String aniversario;

    //constructor
    public Pessoa() {
        this.id = 1;
        this.nome = "";
        this.telefone = "";
        this.tipo = "";
        this.email = "";
        this.endereco = "";
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
        this.facebook = "";
        this.LinkedIn = "";
        this.Instagram = "";
        this.Spotify = "";
        this.aniversario = "";
    }

    public Pessoa(int id,
                  String nome,
                  String telefone,
                  String tipo,
                  String email,
                  String endereco,
                  int dia,
                  int mes,
                  int ano,
                  String facebook,
                  String linkedin,
                  String instagram,
                  String youtube,
                  String spotify,
                  String aniversario) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.email = email;
        this.endereco = endereco;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.facebook = facebook;
        this.LinkedIn = linkedin;
        this.Instagram = instagram;
        this.Youtube = youtube;
        this.Spotify = spotify;
        this.aniversario = aniversario;
    }

    //getters
    public static int getId() {
        return id;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public static String getEndereco() {
        return endereco;
    }

    public static void setEndereco(String endereco) {
        Pessoa.endereco = endereco;
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
        if (email == null) {
            this.email = "";
        } else {
            this.email = email;
        }
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

    public static String getAniversario() {
        return (aniversario);
    }

    public void setAniversario(String aniversario) {
        if (aniversario == null) {
            this.aniversario = "";
        } else {
            this.aniversario = aniversario;
        }
    }

    public static int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public static int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public static String getFacebook() {
        if (facebook == null) {
            return "nada Facebook";
        } else {
            return facebook;
        }
    }

    public void setFacebook(String facebook) {
        if (facebook == null) {
            this.facebook = "";
        } else {
            this.facebook = facebook;
        }
    }

    public static String getLinkedIn() {
        if (LinkedIn == null) {
            return "nada Linked In";
        } else {
            return LinkedIn;
        }
    }

    public void setLinkedIn(String linkedIn) {
        if (linkedIn == null) {
            this.Instagram = "";
        } else {
            this.LinkedIn = linkedIn;
        }
    }

    public static String getInstagram() {
        if (Instagram == null) {
            return "nada Instagram";
        } else {
            return Youtube;
        }
    }

    public void setInstagram(String instagram) {
        if (instagram == null) {
            this.Instagram = "";
        } else {
            this.Instagram = instagram;
        }
    }

    public static String getYoutube() {
        if (Youtube == null) {
            return "nada Youtube";
        } else {
            return Youtube;
        }
    }

    public void setYoutube(String youtube) {
        if (youtube == null) {
            this.Youtube = "";
        } else {
            this.Youtube = youtube;
        }
    }

    public String getSpotify() {
        if (Spotify == null) {
            return "nada Spotify";
        } else {
            return Spotify;
        }
    }

    public void setSpotify(String spotify) {
        if (spotify == null) {
            this.Spotify = "";
        } else {
            this.Spotify = spotify;
        }
    }

    public String getTwitter() {
        if (Twitter == null) {
            return "nada twitter";
        } else {
            return Twitter;
        }
    }

    public void setTwitter(String twitter) {
        if (twitter == null) {
            this.Twitter = "";
        } else {
            this.Twitter = twitter;
        }
    }
}