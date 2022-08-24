package hello.core.beanfind;

import hello.core.AppConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//   @Test
//   @DisplayName("모든 빈 출력하기")
//   void findAllBean(){
//       String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//       //iter + tap -> for문 자동   리스트,배열 있을때
//       for (String beanDefinitionName : beanDefinitionNames) {
//           Object bean = ac.getBean(beanDefinitionName);
//          // System.out.println("ApplicationContextInfoTest.findAllBean"); //soutm
//           System.out.println("name = " + beanDefinitionName+"object = "+bean);
//       }
//   }
   //내가 짠 것만 출력하기
   @Test
   @DisplayName("애플리케이션 빈 출력하기")
   void findApplicationBean(){
       String[] beanDefinitionNames = ac.getBeanDefinitionNames();
       //iter + tap -> for문 자동   리스트,배열 있을때
       for (String beanDefinitionName : beanDefinitionNames) {

           BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
           //ROLE_APPLICATION 일반적으로 사용자가 정의한 빈
           //ROLE_INFRASTRUCTURE 스프링이 내부에서 사용하는 빈
           if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
               Object bean = ac.getBean(beanDefinitionName);
               System.out.println("name = " + beanDefinitionName+"object = "+bean);
           }
       }
   }
   //에러 뜨는 것-> 테스트 Method를 여러개 작성했는데 1개만 실행하였을 경우 위와 같은 Info Message가 뜸


}
