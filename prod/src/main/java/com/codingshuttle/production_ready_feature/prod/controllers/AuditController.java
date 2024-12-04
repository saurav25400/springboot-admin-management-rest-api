package com.codingshuttle.production_ready_feature.prod.controllers;

import com.codingshuttle.production_ready_feature.prod.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.hibernate.envers.AuditReader;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")

@RequiredArgsConstructor
public class AuditController {




//    @GetMapping(path="/getRevision/{postId}")
//    public List<PostEntity> getPostEntityRevision(@PathVariable Long postId){
//        AuditReader reader=AuditReaderFactory.get(entityManagerFactory.createEntityManager());
//
//        List<Number>revisions=reader.getRevisions(PostEntity.class,postId);
//        return revisions.stream().map(revisionNumber->reader.find(PostEntity.class,postId,revisionNumber))
//                .collect(Collectors.toList());
//    }


}
