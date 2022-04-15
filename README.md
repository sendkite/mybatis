## 마이바티스 적응기 

### 버전 정보 

- Spring-Boot 2.6.6
- Maven 3.8.4
- Mysql 8.0.28
- Mybatis-Spring 2.2.2

---

### 사용 장비

- Intelij
- M1 MAC 


### 핵심 개념

- [마이바티스 핵심 컴포넌트](https://yeoon.tistory.com/84?category=1008301)
- [JDBC와 DBCP](https://yeoon.tistory.com/85?category=1008301)
- Spring boot와 연결하기


### 환경 설정 

도커로 mysql 설치 (M1 MAC 기준)

```shell
docker run --platform linux/amd64 -p 3306:3306\
 --name mysql 
 -e MYSQL_ROOT_PASSWORD=1234 
 -e MYSQL_DATABASE=mybatis
 -e MYSQL_PASSWORD=1234 
 -d mysql:8.0.28
```



## Error 분투기 

### 1. mapper/SQL.XML을 못찾는 Error

- 오류 메시지

```shell
java.io.FileNotFoundException: class path resource [mapper/] cannot be opened because it does not exist
```

    

<h3>결론 : db.mapper 와 db/mapper는 다르다. </h3>

    4시간을 삽질하게한 뭐 같은 에러....;;
    DataSouceConfig 파일에 classpath: 를 못 찾는 에러다. 
    희안하게 classpath*:{path} 또는 classpath:/**/mapper/ 로 찾으면 잘 동작했다.

- classpath*:db/mapper/sql-*.xml
- classpath:/**/mapper/sql-*.xml
- classpath:db/mapper/sql-*.xml
- classpath:db.mapper/sql-*.xml 

    
    알고보니 mvn compile 하고 생성되는 target에 db/mapper로 디렉토리 생기는게 아니라, 
    db.mapper로 패키지 형태 들어있었다. 

회사 시니어님이 1분만에 찾아주셨다..😂 잊지말자. db.mapper 와 db/mapper는 다르다. 




```java
class DataSourceConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] resources = applicationContext.getResources("classpath:db/mapper/sql-*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setConfiguration(mybatisConfig());
        return sqlSessionFactoryBean.getObject();
    }
}
```




### 2. Mapper에 메서드가 동작하지 않는 오류

SQL.xml에 있는 namespace에 오타가 있었다.


- 오류 메시지
```shell
org.apache.ibatis.binding.BindingException: Invalid bound statement
```



