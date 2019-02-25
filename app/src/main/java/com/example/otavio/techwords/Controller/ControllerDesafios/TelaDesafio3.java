package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.BancoStatus;
import com.example.otavio.techwords.Model.Palavra;
import com.example.otavio.techwords.Model.Status;
import com.example.otavio.techwords.R;

import java.util.List;

public class TelaDesafio3 extends AppCompatActivity {

    private BancoPalavras bancoPalavras = new BancoPalavras(this);

    private int idFinal;
    private int idInicial;

    private Drawable backgroung;

    private Button btnPalavra1;
    private Button btnPalavra2;
    private Button btnPalavra3;
    private Button btnPalavra4;
    private Button btnPalavra5;

    private Button btnSinonimo1;
    private Button btnSinonimo2;
    private Button btnSinonimo3;
    private Button btnSinonimo4;
    private Button btnSinonimo5;

    private int temp;

    private View.OnClickListener btnVerificarOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int pontos = 0;

            int corP1 = 1;
            int corP2 = 2;
            int corP3 = 3;
            int corP4 = 4;
            int corP5 = 5;

            int corS1 = btnSinonimo1.getPaintFlags();
            int corS2 = btnSinonimo2.getPaintFlags();
            int corS3 = btnSinonimo3.getPaintFlags();
            int corS4 = btnSinonimo4.getPaintFlags();
            int corS5 = btnSinonimo5.getPaintFlags();

            String p1 = String.valueOf(btnPalavra1.getText());
            int idP1 = bancoPalavras.carregaIDPorPalavra(p1);
            String p2 = String.valueOf(btnPalavra2.getText());
            int idP2 = bancoPalavras.carregaIDPorPalavra(p2);
            String p3 = String.valueOf(btnPalavra3.getText());
            int idP3 = bancoPalavras.carregaIDPorPalavra(p3);
            String p4 = String.valueOf(btnPalavra4.getText());
            int idP4 = bancoPalavras.carregaIDPorPalavra(p4);
            String p5 = String.valueOf(btnPalavra5.getText());
            int idP5 = bancoPalavras.carregaIDPorPalavra(p5);

            String s1 = String.valueOf(btnSinonimo1.getText());
            int idS1 = bancoPalavras.carregaIDPorTraducao(s1);
            String s2 = String.valueOf(btnSinonimo2.getText());
            int idS2 = bancoPalavras.carregaIDPorTraducao(s2);
            String s3 = String.valueOf(btnSinonimo3.getText());
            int idS3 = bancoPalavras.carregaIDPorTraducao(s3);
            String s4 = String.valueOf(btnSinonimo4.getText());
            int idS4 = bancoPalavras.carregaIDPorTraducao(s4);
            String s5 = String.valueOf(btnSinonimo5.getText());
            int idS5 = bancoPalavras.carregaIDPorTraducao(s5);

            if ((idP1 == idS1) && (corP1 == corS1)) {
                pontos += 1;
            } else if ((idP1 == idS2) && (corP1 == corS2)) {
                pontos += 1;
            } else if (idP1 == idS3 && corP1 == corS3) {
                pontos += 1;
            } else if (idP1 == idS4 && corP1 == corS4) {
                pontos += 1;
            } else if (idP1 == idS5 && corP1 == corS5) {
                pontos += 1;
            }

            if ((idP2 == idS1) && (corP2 == corS1)) {
                pontos += 1;
            } else if ((idP2 == idS2) && (corP2 == corS2)) {
                pontos += 1;
            } else if (idP2 == idS3 && corP2 == corS3) {
                pontos += 1;
            } else if (idP2 == idS4 && corP2 == corS4) {
                pontos += 1;
            } else if (idP2 == idS5 && corP2 == corS5) {
                pontos += 1;
            }

            if ((idP3 == idS1) && (corP3 == corS1)) {
                pontos += 1;
            } else if ((idP3 == idS2) && (corP3 == corS2)) {
                pontos += 1;
            } else if (idP3 == idS3 && corP3 == corS3) {
                pontos += 1;
            } else if (idP3 == idS4 && corP3 == corS4) {
                pontos += 1;
            } else if (idP3 == idS5 && corP3 == corS5) {
                pontos += 1;
            }

            if ((idP4 == idS1) && (corP4 == corS1)) {
                pontos += 1;
            } else if ((idP4 == idS2) && (corP4 == corS2)) {
                pontos += 1;
            } else if (idP4 == idS3 && corP4 == corS3) {
                pontos += 1;
            } else if (idP4 == idS4 && corP4 == corS4) {
                pontos += 1;
            } else if (idP4 == idS5 && corP4 == corS5) {
                pontos += 1;
            }

            if ((idP5 == idS1) && (corP5 == corS1)) {
                pontos += 1;
            } else if ((idP5 == idS2) && (corP5 == corS2)) {
                pontos += 1;
            } else if (idP5 == idS3 && corP5 == corS3) {
                pontos += 1;
            } else if (idP5 == idS4 && corP5 == corS4) {
                pontos += 1;
            } else if (idP5 == idS5 && corP5 == corS5) {
                pontos += 1;
            }

            if (pontos >= 3) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Você acertou: " + pontos + " palavras.",
                        Toast.LENGTH_LONG);
                toast.show();

                Intent intent = getIntent();
                int disciplina = intent.getIntExtra("disciplina", 0);
                int i = intent.getIntExtra("id", 0);
                i = i + 1;

                BancoStatus bancoStatus = new BancoStatus(getApplicationContext());

                Status s = new Status();
                s.setStatus(i);
                s.setDisciplina(disciplina);

                bancoStatus.aumentaStatus(s);

                finish();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Você acertou: " + pontos + " palavras. \n Tente novamente!",
                        Toast.LENGTH_LONG);
                toast.show();

                Intent intent = getIntent();
                int disciplina = intent.getIntExtra("disciplina", 0);
                int i = intent.getIntExtra("id", 0);
                i = i - 4;

                BancoStatus bancoStatus = new BancoStatus(getApplicationContext());

                Status s = new Status();
                s.setStatus(i);
                s.setDisciplina(disciplina);

                bancoStatus.aumentaStatus(s);

                finish();
            }

        }
    };

    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Termine o teste primeiro.",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio3);

        Intent intent = getIntent();
        this.idFinal = intent.getIntExtra("id", 0);
        this.idInicial = idFinal - 4;

        btnPalavra1 = findViewById(R.id.btnP1);
        btnPalavra2 = findViewById(R.id.btnP2);
        btnPalavra3 = findViewById(R.id.btnP3);
        btnPalavra4 = findViewById(R.id.btnP4);
        btnPalavra5 = findViewById(R.id.btnP5);

        btnSinonimo1 = findViewById(R.id.btnS1);
        btnSinonimo2 = findViewById(R.id.btnS2);
        btnSinonimo3 = findViewById(R.id.btnS3);
        btnSinonimo4 = findViewById(R.id.btnS4);
        btnSinonimo5 = findViewById(R.id.btnS5);


        this.inserirPalavras();
        this.inserirSinonimos();

        Button btnVerificar = findViewById(R.id.btnVerificar3);
        btnVerificar.setOnClickListener(btnVerificarOnClick);

    }

    private void inserirPalavras() {
        List<Palavra> palavras = bancoPalavras.carregaDadosAleatorio(idInicial, idFinal);

        String palavra1 = palavras.get(0).getPalavra();
        backgroung = btnPalavra1.getBackground();
        btnPalavra1.setText(palavra1);
        btnPalavra1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    btnPalavra1.setBackgroundColor(Color.BLUE);
                    temp = 1;
                } else {
                    if (temp == 1) {
                        btnPalavra1.setBackground(backgroung);
                    } else if (temp == 2) {
                        btnPalavra2.setBackground(backgroung);
                    } else if (temp == 3) {
                        btnPalavra3.setBackground(backgroung);
                    } else if (temp == 4) {
                        btnPalavra4.setBackground(backgroung);
                    } else if (temp == 5) {
                        btnPalavra5.setBackground(backgroung);
                    }
                    temp = 0;
                }
            }
        });

        String palavra2 = palavras.get(1).getPalavra();
        btnPalavra2.setText(palavra2);
        btnPalavra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    btnPalavra2.setBackgroundColor(Color.GRAY);
                    temp = 2;
                } else {
                    if (temp == 1) {
                        btnPalavra1.setBackground(backgroung);
                    } else if (temp == 2) {
                        btnPalavra2.setBackground(backgroung);
                    } else if (temp == 3) {
                        btnPalavra3.setBackground(backgroung);
                    } else if (temp == 4) {
                        btnPalavra4.setBackground(backgroung);
                    } else if (temp == 5) {
                        btnPalavra5.setBackground(backgroung);
                    }
                    temp = 0;
                }
            }
        });

        String palavra3 = palavras.get(2).getPalavra();
        btnPalavra3.setText(palavra3);
        btnPalavra3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    btnPalavra3.setBackgroundColor(Color.YELLOW);
                    temp = 3;
                } else {
                    if (temp == 1) {
                        btnPalavra1.setBackground(backgroung);
                    } else if (temp == 2) {
                        btnPalavra2.setBackground(backgroung);
                    } else if (temp == 3) {
                        btnPalavra3.setBackground(backgroung);
                    } else if (temp == 4) {
                        btnPalavra4.setBackground(backgroung);
                    } else if (temp == 5) {
                        btnPalavra5.setBackground(backgroung);
                    }
                    temp = 0;
                }
            }
        });

        String palavra4 = palavras.get(3).getPalavra();
        btnPalavra4.setText(palavra4);
        btnPalavra4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    btnPalavra4.setBackgroundColor(Color.GREEN);
                    temp = 4;
                } else {
                    if (temp == 1) {
                        btnPalavra1.setBackground(backgroung);
                    } else if (temp == 2) {
                        btnPalavra2.setBackground(backgroung);
                    } else if (temp == 3) {
                        btnPalavra3.setBackground(backgroung);
                    } else if (temp == 4) {
                        btnPalavra4.setBackground(backgroung);
                    } else if (temp == 5) {
                        btnPalavra5.setBackground(backgroung);
                    }
                    temp = 0;
                }
            }
        });

        String palavra5 = palavras.get(4).getPalavra();
        btnPalavra5.setText(palavra5);
        btnPalavra5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 0) {
                    btnPalavra5.setBackgroundColor(Color.RED);
                    temp = 5;
                } else {
                    if (temp == 1) {
                        btnPalavra1.setBackground(backgroung);
                    } else if (temp == 2) {
                        btnPalavra2.setBackground(backgroung);
                    } else if (temp == 3) {
                        btnPalavra3.setBackground(backgroung);
                    } else if (temp == 4) {
                        btnPalavra4.setBackground(backgroung);
                    } else if (temp == 5) {
                        btnPalavra5.setBackground(backgroung);
                    }
                    temp = 0;
                }
            }
        });
    }

    private void inserirSinonimos() {
        List<Palavra> palavras = bancoPalavras.carregaDadosAleatorio(idInicial, idFinal);

        String sinonimo1 = palavras.get(0).getTraducao();
        btnSinonimo1.setText(sinonimo1);
        btnSinonimo1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo1.setBackgroundColor(Color.BLUE);
                    btnSinonimo1.setPaintFlags(1);
                } else if (temp == 2) {
                    btnSinonimo1.setBackgroundColor(Color.GRAY);
                    btnSinonimo1.setPaintFlags(2);
                } else if (temp == 3) {
                    btnSinonimo1.setBackgroundColor(Color.YELLOW);
                    btnSinonimo1.setPaintFlags(3);
                } else if (temp == 4) {
                    btnSinonimo1.setBackgroundColor(Color.GREEN);
                    btnSinonimo1.setPaintFlags(4);
                } else if (temp == 5) {
                    btnSinonimo1.setBackgroundColor(Color.RED);
                    btnSinonimo1.setPaintFlags(5);
                } else if (temp == 0) {
                    btnSinonimo1.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        String sinonimo2 = palavras.get(1).getTraducao();
        btnSinonimo2.setText(sinonimo2);
        btnSinonimo2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo2.setBackgroundColor(Color.BLUE);
                    btnSinonimo2.setPaintFlags(1);
                } else if (temp == 2) {
                    btnSinonimo2.setBackgroundColor(Color.GRAY);
                    btnSinonimo2.setPaintFlags(2);
                } else if (temp == 3) {
                    btnSinonimo2.setBackgroundColor(Color.YELLOW);
                    btnSinonimo2.setPaintFlags(3);
                } else if (temp == 4) {
                    btnSinonimo2.setBackgroundColor(Color.GREEN);
                    btnSinonimo2.setPaintFlags(4);
                } else if (temp == 5) {
                    btnSinonimo2.setBackgroundColor(Color.RED);
                    btnSinonimo2.setPaintFlags(5);
                } else if (temp == 0) {
                    btnSinonimo2.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        String sinonimo3 = palavras.get(2).getTraducao();
        btnSinonimo3.setText(sinonimo3);
        btnSinonimo3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo3.setBackgroundColor(Color.BLUE);
                    btnSinonimo3.setPaintFlags(1);
                } else if (temp == 2) {
                    btnSinonimo3.setBackgroundColor(Color.GRAY);
                    btnSinonimo3.setPaintFlags(2);
                } else if (temp == 3) {
                    btnSinonimo3.setBackgroundColor(Color.YELLOW);
                    btnSinonimo3.setPaintFlags(3);
                } else if (temp == 4) {
                    btnSinonimo3.setBackgroundColor(Color.GREEN);
                    btnSinonimo3.setPaintFlags(4);
                } else if (temp == 5) {
                    btnSinonimo3.setBackgroundColor(Color.RED);
                    btnSinonimo3.setPaintFlags(5);
                } else if (temp == 0) {
                    btnSinonimo3.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        String sinonimo4 = palavras.get(3).getTraducao();
        btnSinonimo4.setText(sinonimo4);
        btnSinonimo4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo4.setBackgroundColor(Color.BLUE);
                    btnSinonimo4.setPaintFlags(1);
                } else if (temp == 2) {
                    btnSinonimo4.setBackgroundColor(Color.GRAY);
                    btnSinonimo4.setPaintFlags(2);
                } else if (temp == 3) {
                    btnSinonimo4.setBackgroundColor(Color.YELLOW);
                    btnSinonimo4.setPaintFlags(3);
                } else if (temp == 4) {
                    btnSinonimo4.setBackgroundColor(Color.GREEN);
                    btnSinonimo4.setPaintFlags(4);
                } else if (temp == 5) {
                    btnSinonimo4.setBackgroundColor(Color.RED);
                    btnSinonimo4.setPaintFlags(5);
                } else if (temp == 0) {
                    btnSinonimo4.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        String sinonimo5 = palavras.get(4).getTraducao();
        btnSinonimo5.setText(sinonimo5);
        btnSinonimo5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo5.setBackgroundColor(Color.BLUE);
                    btnSinonimo5.setPaintFlags(1);
                } else if (temp == 2) {
                    btnSinonimo5.setBackgroundColor(Color.GRAY);
                    btnSinonimo5.setPaintFlags(2);
                } else if (temp == 3) {
                    btnSinonimo5.setBackgroundColor(Color.YELLOW);
                    btnSinonimo5.setPaintFlags(3);
                } else if (temp == 4) {
                    btnSinonimo5.setBackgroundColor(Color.GREEN);
                    btnSinonimo5.setPaintFlags(4);
                } else if (temp == 5) {
                    btnSinonimo5.setBackgroundColor(Color.RED);
                    btnSinonimo5.setPaintFlags(5);
                } else if (temp == 0) {
                    btnSinonimo5.setBackground(backgroung);
                }
                temp = 0;
            }
        });
    }

}
