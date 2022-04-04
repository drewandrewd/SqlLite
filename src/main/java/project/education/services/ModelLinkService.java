package project.education.services;

import project.education.exceptions.JsonRpcException;

import java.util.List;

public interface ModelLinkService {

    Long create(String name, Long classNodeId) throws Throwable;

    void update(String name, Long modelNodeId, Long classNodeId) throws Throwable;

    void delete(Long modelNodeId) throws Throwable;

    String fetchByClassNodeId(Long classNodeId) throws Throwable;

    Long fetchByModelNodeId(Long modelNodeId) throws Throwable;

    List<Long> fetchModelsByClassNodeId(Long lassNodeId) throws JsonRpcException;
}
