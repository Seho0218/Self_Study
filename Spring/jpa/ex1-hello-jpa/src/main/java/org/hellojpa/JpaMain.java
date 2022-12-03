package org.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //db당 1개

        EntityManager em = emf.createEntityManager();// 단위작업마다 만들어줌

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // C: create, 비영속 상태
            // Member member = new Member();
            // member.setId(2L);
            // member.setName("helloB");

            //영속상태
            // em.detach(member);
            // em.persist(member); 1차 캐시 영속성(임시)

            // R: read
            // Member findMember = em.find(Member.class, 1L);// 객체를 대신 저장
            // System.out.println("findMember.getId() = " + findMember.getId());
            // System.out.println("findMember.getId() = " + findMember.getName());

            // U: update
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            // D: delete
            //em.remove(1L);

            //수작업
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {

                System.out.println("member.getName() = " + member.getName());
                
            }




            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}