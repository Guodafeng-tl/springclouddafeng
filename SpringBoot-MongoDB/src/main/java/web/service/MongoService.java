package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import web.entity.Student;

import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 10:54 2021/1/5
 **/
@Service
public class MongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 保存对象
     * @param student
     */
    public void saveInfo(Student student){
        mongoTemplate.save(student,"test");
    }

    public List<Student> findAll(){
        return mongoTemplate.findAll(Student.class,"test");
    }

    public List<Student> findStudentById(Student student){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(student.getId()));
        List<Student> test = mongoTemplate.find(query, Student.class, "test");
        return test;
    }

    public void updateStudent(Student student){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(student.getId()));

        Update update = new Update();
        update.set("name",student.getName());
        update.set("age",student.getAge());

        /**
         * upsert()没有会新建
         */
        //mongoTemplate.upsert(query,update,"test");

        mongoTemplate.updateFirst(query,update,"test");

    }

    public void removeStudent(Student student){
        mongoTemplate.remove(student,"test");
    }

}
