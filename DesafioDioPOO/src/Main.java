

import java.time.LocalDate;

import dominio.Bootcamp;
import dominio.Conteudo;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
        Conteudo curso1 = new Curso();
        curso1.setTitulo("Curso de Java");
        curso1.setDescricao("descrição curso de java");
        ((Curso)curso1).setCargaHoraria(8);

        Conteudo curso2 = new Curso();
        curso2.setTitulo("Curso de JavaScript");
        curso2.setDescricao("descrição curso de js");
        ((Curso)curso2).setCargaHoraria(4);

        Conteudo mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("descrição mentoria de java");
        ((Mentoria)mentoria1).setData(LocalDate.now());

        /* System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1); */

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        System.out.println("===================");
        Dev devPedro = new Dev();
        devPedro.setNome("Pedro");
        devPedro.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + devPedro.getConteudosInscritos());
        System.out.println("===================");
        devPedro.progredir();
        devPedro.progredir();
        System.out.println("Conteúdos inscritos: " + devPedro.getConteudosInscritos());
        System.out.println("Conteúdos concluídos: " + devPedro.getConteudosConcluídos());
        System.out.println("XP: " + devPedro.calcularTotalXP());

        System.out.println("===================");

        Dev devBruno = new Dev();
        devBruno.setNome("Bruno");
        devBruno.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + devPedro.getConteudosInscritos());
        System.out.println("===================");
        devBruno.progredir();
        System.out.println("Conteúdos inscritos: " + devPedro.getConteudosInscritos());
        System.out.println("Conteúdos concluídos: " + devPedro.getConteudosConcluídos());
        System.out.println("XP: " + devBruno.calcularTotalXP());

        System.out.println("===================");

    }
}
