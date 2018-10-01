package br.edu.ifpr.treinamento.aplicacao;
import br.edu.ifpr.treinamento.aplicacao.processors.AlunoProcessor;
import br.edu.ifpr.treinamento.aplicacao.processors.CursoProcessor;
import br.edu.ifpr.treinamento.aplicacao.processors.InstrutorProcessor;
import br.edu.ifpr.treinamento.aplicacao.processors.MatriculaProcessor;
import br.edu.ifpr.treinamento.aplicacao.processors.ModuloProcessor;
import br.edu.ifpr.treinamento.modelo.service.JpaService;

public class TreinamentoPrincipal {
    private JpaService js = null;
  
    private AlunoProcessor       ap;
    private InstrutorProcessor   ip;
    private CursoProcessor       cp;
    private ModuloProcessor      mop;
    private MatriculaProcessor   map;
  
    private void openEntityManagerFactory() {
       js = new JpaService();
       js.createEntityManagerFactory();
    }
  
    private void closeEntityManagerFactory() {
       js.closeEntityManagerFactory();
    }
  
    private void initProcessors() {
       ap  = new AlunoProcessor(js);
       ip  = new InstrutorProcessor(js);
       //mop = new ModuloProcessor(js);
       //cp  = new CursoProcessor(js);
       //map = new MatriculaProcessor(js);
    }
  
    public TreinamentoPrincipal() {
       System.out.println("@@@ INICIALIZANDO PERSISTÊNCIA @@@");
       openEntityManagerFactory();
  
       // depois de 'openEntityManagerFactory()', pois o objeto 'emf'
       // já terá sido inicializado
       initProcessors();
       ap.processAlunos();
       ip.processInstrutores();
//       mop.processModulos();
//       cp.processCursos();
//       map.processMatriculas();
  
       System.out.println("@@@ ENCERRANDO PERSISTÊNCIA @@@");
       closeEntityManagerFactory();
    }
  
     public static void main(String[] args) {
        new TreinamentoPrincipal();
     }
 }