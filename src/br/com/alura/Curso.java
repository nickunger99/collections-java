package br.com.alura;


import java.util.*;

public class Curso {
    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<>();
    private Set<Aluno> alunos = new HashSet<>();

    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
    //private Map<Integer, Aluno> matriculaParaAluno= new Hashtable<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }


    public int getTempoTotal() {
//        int tempoTotal = 0;
//        for( Aula aula: aulas){
//            tempoTotal += aula.getTempo();
//        }
//        return tempoTotal;
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + ","
                + "aulas: " + this.aulas + "]";
    }

    public void matricula(Aluno aluno) {
        this.alunos.add(aluno);
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public boolean estaMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno buscaMatriculado(int numero) {
//        for (Aluno aluno :
//                alunos) {
//            if(aluno.getNumeroMatricula() == numero)
//                return aluno;
//        }

//        throw  new NoSuchElementException("matricula nao encontrada" + numero);
        if(!matriculaParaAluno.containsKey(numero)) throw new NoSuchElementException("matricula não encontrada :" + numero);
        return matriculaParaAluno.get(numero);
    }
}
