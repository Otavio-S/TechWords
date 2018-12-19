package com.example.otavio.techwords.Controller.ControllerDesafios;

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

    private Button btnVerificar;
    private View.OnClickListener btnVerificarOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int pontos = 0;
            int corP1 = btnPalavra1.getSolidColor();
            int corP2 = btnPalavra2.getSolidColor();
            int corP3 = btnPalavra3.getSolidColor();
            int corP4 = btnPalavra4.getSolidColor();
            int corP5 = btnPalavra5.getSolidColor();

            int corS1 = btnSinonimo1.getSolidColor();
            int corS2 = btnSinonimo2.getSolidColor();
            int corS3 = btnSinonimo3.getSolidColor();
            int corS4 = btnSinonimo4.getSolidColor();
            int corS5 = btnSinonimo5.getSolidColor();

            int idP1 = btnPalavra1.getId();
            int idP2 = btnPalavra2.getId();
            int idP3 = btnPalavra3.getId();
            int idP4 = btnPalavra4.getId();
            int idP5 = btnPalavra5.getId();

            int idS1 = btnSinonimo1.getId();
            int idS2 = btnSinonimo2.getId();
            int idS3 = btnSinonimo3.getId();
            int idS4 = btnSinonimo4.getId();
            int idS5 = btnSinonimo5.getId();


            if (idP1 == idS1 && corP1 == corS1) {
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

            if (idP2 == idS1 && corP2 == corS1) {
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

            if (idP3 == idS1 && corP3 == corS1) {
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

            if (idP4 == idS1 && corP4 == corS1) {
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

            if (idP5 == idS1 && corP5 == corS1) {
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

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Você acertou: " + pontos + " palavras.",
                    Toast.LENGTH_LONG);
            toast.show();

            if (pontos >= 3) {
                Intent intent = getIntent();
                int disciplina = intent.getIntExtra("disciplina", 0);
                int i = intent.getIntExtra("id", 0);
                i = i+1;

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

        btnVerificar = findViewById(R.id.btnVerificar3);
        btnVerificar.setOnClickListener(btnVerificarOnClick);

    }

    private void inserirPalavras() {
        List<Palavra> palavras = bancoPalavras.carregaDadosAleatorio(idInicial, idFinal);

        btnPalavra1.setId(palavras.get(0).getId());
        String palavra1 = palavras.get(0).getPalavra();
        backgroung = btnPalavra1.getBackground();
        btnPalavra1.setText(palavra1);
        btnPalavra1.setOnClickListener(new View.OnClickListener() {
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

        btnPalavra2.setId(palavras.get(1).getId());
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

        btnPalavra3.setId(palavras.get(2).getId());
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

        btnPalavra4.setId(palavras.get(3).getId());
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

        btnPalavra5.setId(palavras.get(4).getId());
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

        btnSinonimo1.setId(palavras.get(0).getId());
        String sinonimo1 = palavras.get(0).getSinonimo();
        btnSinonimo1.setText(sinonimo1);
        btnSinonimo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo1.setBackgroundColor(Color.BLUE);
                } else if (temp == 2) {
                    btnSinonimo1.setBackgroundColor(Color.GRAY);
                } else if (temp == 3) {
                    btnSinonimo1.setBackgroundColor(Color.YELLOW);
                } else if (temp == 4) {
                    btnSinonimo1.setBackgroundColor(Color.GREEN);
                } else if (temp == 5) {
                    btnSinonimo1.setBackgroundColor(Color.RED);
                } else if (temp == 0){
                    btnSinonimo1.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        btnSinonimo2.setId(palavras.get(1).getId());
        String sinonimo2 = palavras.get(1).getSinonimo();
        btnSinonimo2.setText(sinonimo2);
        btnSinonimo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo2.setBackgroundColor(Color.BLUE);
                } else if (temp == 2) {
                    btnSinonimo2.setBackgroundColor(Color.GRAY);
                } else if (temp == 3) {
                    btnSinonimo2.setBackgroundColor(Color.YELLOW);
                } else if (temp == 4) {
                    btnSinonimo2.setBackgroundColor(Color.GREEN);
                } else if (temp == 5) {
                    btnSinonimo2.setBackgroundColor(Color.RED);
                } else if (temp == 0){
                    btnSinonimo2.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        btnSinonimo3.setId(palavras.get(2).getId());
        String sinonimo3 = palavras.get(2).getSinonimo();
        btnSinonimo3.setText(sinonimo3);
        btnSinonimo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo3.setBackgroundColor(Color.BLUE);
                } else if (temp == 2) {
                    btnSinonimo3.setBackgroundColor(Color.GRAY);
                } else if (temp == 3) {
                    btnSinonimo3.setBackgroundColor(Color.YELLOW);
                } else if (temp == 4) {
                    btnSinonimo3.setBackgroundColor(Color.GREEN);
                } else if (temp == 5) {
                    btnSinonimo3.setBackgroundColor(Color.RED);
                } else if (temp == 0){
                    btnSinonimo3.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        btnSinonimo4.setId(palavras.get(3).getId());
        String sinonimo4 = palavras.get(3).getSinonimo();
        btnSinonimo4.setText(sinonimo4);
        btnSinonimo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo4.setBackgroundColor(Color.BLUE);
                } else if (temp == 2) {
                    btnSinonimo4.setBackgroundColor(Color.GRAY);
                } else if (temp == 3) {
                    btnSinonimo4.setBackgroundColor(Color.YELLOW);
                } else if (temp == 4) {
                    btnSinonimo4.setBackgroundColor(Color.GREEN);
                } else if (temp == 5) {
                    btnSinonimo4.setBackgroundColor(Color.RED);
                } else if (temp == 0){
                    btnSinonimo4.setBackground(backgroung);
                }
                temp = 0;
            }
        });

        btnSinonimo5.setId(palavras.get(4).getId());
        String sinonimo5 = palavras.get(4).getSinonimo();
        btnSinonimo5.setText(sinonimo5);
        btnSinonimo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp == 1) {
                    btnSinonimo5.setBackgroundColor(Color.BLUE);
                } else if (temp == 2) {
                    btnSinonimo5.setBackgroundColor(Color.GRAY);
                } else if (temp == 3) {
                    btnSinonimo5.setBackgroundColor(Color.YELLOW);
                } else if (temp == 4) {
                    btnSinonimo5.setBackgroundColor(Color.GREEN);
                } else if (temp == 5) {
                    btnSinonimo5.setBackgroundColor(Color.RED);
                } else if (temp == 0){
                    btnSinonimo5.setBackground(backgroung);
                }
                temp = 0;
            }
        });
    }

}
