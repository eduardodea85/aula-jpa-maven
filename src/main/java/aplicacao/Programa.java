package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager(); //Conexão com o banco de dados
		
		//Código necessário para Salvar as 3 pessoas no banco de dados. precisa trocar o id das pessoas para null.
		//em.getTransaction().begin(); //quando o jpa não apenas lê o bd, ele precisa de uma transação para iniciar.
		//em.persist(p1); //Persist é o objeto que salva no banco de dados
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit(); //Confirma as alterações feitas no bd.
		
		//Buscar uma pessoa do bd, depois de já ter adicionado eles.
		//Pessoa p = em.find(Pessoa.class, 4);
		
		//Para apagar uma pessoa do bd
		Pessoa p = em.find(Pessoa.class, 4);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
				
		//System.out.println(p);
		
		System.out.println("Pronto");
		
		em.close();
		emf.close(); //fechando a conexão com o bd.
		
		//System.out.println(p1);
		//System.out.println(p2);
		//System.out.println(p3);

	}

}
