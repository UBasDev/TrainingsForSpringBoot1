package org.group1.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.group1.entities.BaseEntity;
import org.group1.entities.Product;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.metamodel.RepresentationMode;
import org.hibernate.metamodel.spi.EntityRepresentationStrategy;
import org.hibernate.type.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;

@Slf4j
@Component
public class CustomInterceptor1 implements Interceptor, Serializable {

    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override //Object create ve update olduğu zaman çalışır.
    public boolean onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof BaseEntity) {
            findPropertyIndex("updatedDate", propertyNames, currentState);

        }

        return Interceptor.super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    private static void findPropertyIndex(String columnToSearch, String[] propertyNames, Object[] currentState) {
        for (short i = 0; i < propertyNames.length; i++) {
            if (columnToSearch.equals(propertyNames[i])) {
                currentState[i] = LocalDateTime.now();
                break;
            }
        }
    }

    @Override //Object create edildiği zaman çalışır.
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof BaseEntity) {
            findPropertyIndex("updatedDate", propertyNames, state);
            findPropertyIndex("createdDate", propertyNames, state);
            log.info("New product object has been created");
            log.info(entity.toString());
        }
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }

    @Override //Object delete edildiği zaman çalışır.
    public void onDelete(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        Interceptor.super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public void onCollectionRecreate(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionRecreate(collection, key);
    }

    @Override
    public void onCollectionRemove(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionRemove(collection, key);
    }

    @Override
    public void onCollectionUpdate(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionUpdate(collection, key);
    }

    @Override
    public void preFlush(Iterator<Object> entities) throws CallbackException {
        Interceptor.super.preFlush(entities);
    }

    @Override
    public void postFlush(Iterator<Object> entities) throws CallbackException {
        Interceptor.super.postFlush(entities);
    }

    @Override
    public Boolean isTransient(Object entity) {
        return Interceptor.super.isTransient(entity);
    }

    @Override
    public int[] findDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return Interceptor.super.findDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public Object instantiate(String entityName, EntityRepresentationStrategy representationStrategy, Object id) throws CallbackException {
        return Interceptor.super.instantiate(entityName, representationStrategy, id);
    }

    @Override
    public Object instantiate(String entityName, RepresentationMode representationMode, Object id) throws CallbackException {
        return Interceptor.super.instantiate(entityName, representationMode, id);
    }

    @Override
    public String getEntityName(Object object) throws CallbackException {
        return Interceptor.super.getEntityName(object);
    }

    @Override
    public Object getEntity(String entityName, Object id) throws CallbackException {
        return Interceptor.super.getEntity(entityName, id);
    }

    @Override
    public void afterTransactionBegin(Transaction tx) {
        Interceptor.super.afterTransactionBegin(tx);
    }

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        Interceptor.super.beforeTransactionCompletion(tx);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        Interceptor.super.afterTransactionCompletion(tx);
    }

}