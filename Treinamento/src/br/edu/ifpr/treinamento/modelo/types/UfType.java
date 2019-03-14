package br.edu.ifpr.treinamento.modelo.types;

public enum UfType
{
    ACRE("AC", "Acre") {
        @Override
        public String toString() {
            return "Acre";
        }
    },
    ALAGOAS("AL", "Alagoas") {
        @Override
        public String toString() {
            return "Alagoas";
        }
    },
    AMAPA("AP", "Amapá") {
        @Override
        public String toString() {
            return "Amapá";
        }
    },
    AMAZONAS("AM", "Amazonas") {
        @Override
        public String toString() {
            return "Amazonas";
        }
    },
    BAHIA("BA", "Bahia") {
        @Override
        public String toString() {
            return "Bahia";
        }
    },
    CEARA("CE", "Ceará") {
        @Override
        public String toString() {
            return "Ceará";
        }
    },
    DISTRITO_FEDERAL("DF", "Distrito Federal") {
        @Override
        public String toString() {
            return "Distrito Federal";
        }
    },
    ESPIRITO_SANTO("ES", "Espírito Santo") {
        @Override
        public String toString() {
            return "Espírito Santo";
        }
    },
    GOIAS("GO", "Goiás") {
        @Override
        public String toString() {
            return "Goiás";
        }
    },
    MARANHAO("MA", "Maranhão") {
        @Override
        public String toString() {
            return "Maranhão";
        }
    },
    MATO_GROSSO("MT", "Mato Grosso") {
        @Override
        public String toString() {
            return "Mato Grosso";
        }
    },
    MATO_GROSSO_SUL("MS", "Mato Grosso do Sul") {
        @Override
        public String toString() {
            return "Mato Grosso do Sul";
        }
    },
    MINAS_GERAIS("MG", "Minas Gerais") {
        @Override
        public String toString() {
            return "Minas Gerais";
        }
    },
    PARA("PA", "Pará") {
        @Override
        public String toString() {
            return "Pará";
        }
    },
    PARAIBA("PB", "Paraíba") {
        @Override
        public String toString() {
            return "Paraíba";
        }
    },
    PARANA("PR", "Paraná") {
        @Override
        public String toString() {
            return "Paraná";
        }
    },
    PERNAMBUCO("PE", "Pernambuco") {
        @Override
        public String toString() {
            return "Pernambuco";
        }
    },
    PIAUI("PI", "Rio de Janeiro") {
        @Override
        public String toString() {
            return "Piauí";
        }
    },
    RIO_JANEIRO("RJ", "Rio de Janeiro") {
        @Override
        public String toString() {
            return "Rio de Janeiro";
        }
    },
    RIO_GRANDE_NORTE("RN", "Rio Grande do Norte") {
        @Override
        public String toString() {
            return "Rio Grande do Norte";
        }
    },
    RIO_GRANDE_SUL("RS", "Rio Grande do Sul") {
        @Override
        public String toString() {
            return "Rio Grande do Sul";
        }
    },
    RONDONIA("RO", "Rondônia") {
        @Override
        public String toString() {
            return "Rondônia";
        }
    },
    RORAIMA("RR", "Roraima") {
        @Override
        public String toString() {
            return "Roraima";
        }
    },
    SANTA_CATARINA("SC", "Santa Catarina") {
        @Override
        public String toString() {
            return "Santa Catarina";
        }
    },
    SAO_PAULO("SP", "São Paulo") {
        @Override
        public String toString() {
            return "São Paulo";
        }
    },
    SERGIPE("SE", "Sergipe") {
        @Override
        public String toString() {
            return "Sergipe";
        }
    },
    TOCANTINS("TO", "Tocantins") {
        @Override
        public String toString() {
            return "Tocantins";
        }
    };

    private String sigla;
    private String nome;

    private UfType(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String sigla() {
        return sigla;
    }

    public String nome() {
        return nome;
    }
}
