/**
 * ---------------------------------------------- Documentacao preliminar
 * Pontificia Universidade Catolica de Minas Gerais
 * Curso de Ciencia da Computacao
 * LDDM
 * <p>
 * Autor: Bernardo Morais Alfredo  Matricula: 565524
 * Versao:  0.06                Data: 18/03/2018
 * <p>
 * Dados:
 * - Ler dados de uma pessoa e criar evento no calendario.
 * <p>
 * Para funcionar:
 * <p>
 * Insira (nas dependencies de build.gradle (Module:App) :
 * compile fileTree(dir: 'libs', include: ['*.jar'])
 * compile 'com.android.support:design:22.2.0'
 * compile 'com.android.support:appcompat-v7:22.2.0'
 * <p>
 * Resultados:
 * <p>
 * -Funciona
 * <p>
 * Feito com ajuda de:
 * Luiz Braganca
 */
package com.person.bernardo.myperson;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static Pessoa contato = new Pessoa();
    EditText nome, nasc, tel, email, endereco;
    // Variavel para utilizar o vibrador
    private Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBotoes();
    }

    /**
     * Metodo para converter EditText em String.
     * @param txt
     * @return
     */
    public String converteTexto(EditText txt) {
        // definir dados
        String resp = txt.getText().toString();
        return (resp);
    }// end converteTexto( )

    /**
     * Metodo para verificar cada botao.
     */
    private void setBotoes() {
        // definindo botoes
        Button addContato = findViewById(R.id.addContato),
                salvaAniv = findViewById(R.id.anivesario),
                envWhatsapp = findViewById(R.id.whatsapp),
                save = findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = findViewById(R.id.nome);
                nasc = findViewById(R.id.nascimento);
                tel = findViewById(R.id.phone);
                email = findViewById(R.id.email);
                endereco = findViewById(R.id.endereco);
            }// end onClick( )
        });

        // definindo os editText
        nome = findViewById(R.id.nome);
        nasc = findViewById(R.id.nascimento);
        tel = findViewById(R.id.phone);
        email = findViewById(R.id.email);
                endereco = findViewById(R.id.endereco);

        final TextInputLayout nomeInput = findViewById(R.id.input_layout_nome),
                nascInput = findViewById(R.id.input_layout_data),
                telInput = findViewById(R.id.input_layout_telefone),
                emailInput = findViewById(R.id.input_layout_email),
                endInput = findViewById(R.id.input_layout_endereco);

        //Inicializando a variavel vibrator
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // botao de adicionar contato
        addContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emptyNome = TextUtils.isEmpty(converteTexto(nome)),
                        emptyEmail = TextUtils.isEmpty(converteTexto(email)),
                        emptytel = TextUtils.isEmpty(converteTexto(tel)),
                        emptyAddress = TextUtils.isEmpty(converteTexto(endereco));

                //Mostrar Erro se Nome Vazio
                if (emptyNome) {
                    vib.vibrate(120);
                    nomeInput.setErrorEnabled(true);
                    nomeInput.setError(getResources().getString(R.string.erro_EditText_Nome));
                }// end if

                //Mostrar Erro se Email Vazio
                if (emptyEmail) {
                    vib.vibrate(120);
                    emailInput.setErrorEnabled(true);
                    emailInput.setError(getResources().getString(R.string.erro_EditText_Email));
                }// end if

                //Mostrar Erro se Telefone Vazio
                if (emptytel) {
                    vib.vibrate(120);
                    telInput.setErrorEnabled(true);
                    telInput.setError(getResources().getString(R.string.erro_EditText_Tel));
                }// end if

                //Mostrar Erro se Address Vazio
                if (emptyAddress) {
                    vib.vibrate(120);
                    endInput.setErrorEnabled(true);
                    endInput.setError(getResources().getString(R.string.erro_EditText_Endereco));
                }// end if

                //Se os campos nao estiverem vazios:
                if (!emptyNome && !emptyEmail && !emptytel && !emptyAddress) {
                    nomeInput.setErrorEnabled(false);
                    emailInput.setErrorEnabled(false);
                    telInput.setErrorEnabled(false);
                    endInput.setErrorEnabled(false);
                    contato.setNome(converteTexto(nome));
                    contato.setEmail((converteTexto(email)));
                    contato.setTelefone((converteTexto(tel)));
                    contato.setEndereco((converteTexto(endereco)));
                    addContact(converteTexto(nome), converteTexto(email), converteTexto(tel), converteTexto(endereco));
                }// end if
            }// end onClick( )
        });

        // botao de salvar aniversario
        salvaAniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emptyNome = TextUtils.isEmpty(converteTexto(nome)),
                        emptyData = TextUtils.isEmpty(converteTexto(nasc));

                //Mostrar erro se nome vazio.
                if (emptyNome) {
                    vib.vibrate(120);
                    nomeInput.setErrorEnabled(true);
                    nomeInput.setError(getResources().getString(R.string.erro_EditText_Nome));
                }// end if

                //Mostrar erro se data de nascimento vazia.
                if (emptyData) {
                    vib.vibrate(120);
                    nascInput.setErrorEnabled(true);
                    nascInput.setError(getResources().getString(R.string.erro_EditText_Nasc));
                }// end if

                if (!emptyNome && !emptyData) {
                    nomeInput.setErrorEnabled(false);
                    nascInput.setErrorEnabled(false);
                    aniversario(converteTexto(nome), converteTexto(nasc));
                }// end if
            }// end onClick
        });

        // botao de enviar whatsapp
        envWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emptyTel = TextUtils.isEmpty(converteTexto(tel));

                //Mostrar erro se telefone vazio.
                if (emptyTel) {
                    vib.vibrate(120);
                    telInput.setErrorEnabled(true);
                    telInput.setError(getResources().getString(R.string.erro_EditText_Tel));
                }// end if

                //Mostrar erro.
                if (!emptyTel) {
                    telInput.setErrorEnabled(false);
                    whatsapp(converteTexto(tel));
                }// end if
            }// end onClick
        });
    }// end setBotoes( )

    /**
     * Metodo addContact( ) - adicionar um contato.
     *
     * @Param: -Nome = nome contato
     * -Email = email contato
     * -Tel = Telefone contato
     * -End = endereco contato
     */
    public void addContact(String nome, String email, String tel, String end) {
        //define o contato

        // set intent
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        // set nome
        intent.putExtra(ContactsContract.Intents.Insert.NAME, nome);

        // set email
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_HOME);

        // set telefone
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, tel);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);

        // set endereco
        intent.putExtra(ContactsContract.Intents.Insert.POSTAL, end);
        intent.putExtra(ContactsContract.Intents.Insert.POSTAL_TYPE, ContactsContract.CommonDataKinds.StructuredPostal.TYPE_HOME);

        // set intent
        startActivity(intent);
    }// end addContact( )

    /**
     * Metodo para adicionar data de aniversário na agenda.
     */
    public void aniversario(String nome, String nasc) {

        // set data
        int dia, mes, year;
        Intent intent = new Intent(Intent.ACTION_INSERT);

        contato.setAniversario(nasc);

        // get day
        dia = Pessoa.getDia(nasc);
        contato.setDia(dia);

        // get month
        mes = Pessoa.getMes(nasc);
        contato.setMes(mes);

        // get year
        year = Pessoa.getYear(nasc);
        contato.setAno(year);

        // set date
        intent.setData(CalendarContract.Events.CONTENT_URI);

        // set event title
        intent.putExtra(CalendarContract.Events.TITLE, "Aniversário de " + nome);

        // set event time
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        // set start day
        Calendar startTime = Calendar.getInstance();
        startTime.set(2018, mes, dia, 0, 0);

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, startTime.getTimeInMillis());
        intent.putExtra("rrule", "FREQ=YEARLY");

        // iniciando a activity
        startActivity(intent);
    }// end aniversario( )

    /**
     * Metodo que manda mensagem pelo whatsapp.
     *
     * @Param: -Numero Telefone
     */
    public void whatsapp(String number) {
        contato.setTelefone(number);

        // send contact number
        Uri uri = Uri.parse("smsto:" + number);

        // start intent
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);

        // text type
        sendIntent.setPackage("text/plain");

        // add whatsapp package
        sendIntent.setPackage("com.whatsapp");

        // start activity
        startActivity(Intent.createChooser(sendIntent, ""));
    }// end whatsapp( )

    /**
     * Metodo que vai para a segunda tela.
     * @param view
     */
    public void segundaTela(View view) {
        // criando a intent para a segunda tela
        Intent secondScreen = new Intent(this, MainSocial.class);
        Pessoa proxPessoa = new Pessoa();

        proxPessoa.setNome(nome.getText().toString());
        proxPessoa.setTelefone(tel.getText().toString());
        proxPessoa.setEmail(email.getText().toString());
        proxPessoa.setEndereco(endereco.getText().toString());
        proxPessoa.setAniversario(nasc.getText().toString());

        secondScreen.putExtra("proxPessoa", proxPessoa);

        // iniciando
        startActivity(secondScreen);
    }// end segundaTela( )

}// end class
