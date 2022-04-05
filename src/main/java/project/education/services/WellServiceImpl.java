package project.education.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.education.exceptions.WellNotFoundException;
import project.education.models.Well;
import project.education.repositories.WellRepository;

import java.util.List;

@Slf4j
@Service
public class WellServiceImpl implements WellService {

    private WellRepository wellRepository;

    @Override
    public List<Well> findByName(String name) throws WellNotFoundException {
        List<Well> listOfWells = wellRepository.findByName(name);
        if (listOfWells.isEmpty()) {
            throw new WellNotFoundException();
        }
        return listOfWells;
    }

    @Override
    public void create(Well well) {
        wellRepository.save(well);
    }

    //    private ModelRepository modelRepository;
//    private ModelLinkService modelLinkService;
//    private ModelCustomRepository modelCustomRepository;
//
//    @Override
//    public List<Well> findByName(String name) throws ModelNotFoundException {
//        List<Well> model = modelRepository.findByName(name);
//        if (!model.isEmpty()) {
//            //todo action
//        } else {
//            //throw exceptions
//            throw new ModelNotFoundException();
//        }
//        return model;
//    }
//
//    @Override
//    public ModelResponse create(ModelRequest modelRequest) throws Throwable {
//        Well model = converter.requestToModel(modelRequest);
//        model.setCreateAt(new Date());
//        model.setCreator("admin");
//        Long modelNodeId = modelLinkService.create(modelRequest.getName(), modelRequest.getClassNodeId());
//        model.setNodeId(modelNodeId);//todo get from Neo4J component
//        return converter.modelToResponse(modelRepository.save(model));
//    }
//
//    @Override
//    public ModelResponse update(ModelRequest modelRequest) throws Throwable {
//        Well updating = converter.requestToModel(modelRequest);
//        log.info("updating: " + updating);
//        String updatingName = updating.getName();
//        String updatingComment = updating.getComment();
//        ModelType updatingType = updating.getType();
//        Optional<Well> current = modelRepository.findById(updating.getId());
//        log.info("current: " + current);
//        if (current.isPresent()) {
//            Well newModel = current.get();
//            if (!newModel.equals(updating)) {
//                if(!newModel.getName().equals(updatingName)) {
//                    newModel.setName(updatingName);
//                }
//                if(!newModel.getComment().equals(updatingComment)) {
//                    newModel.setComment(updatingComment);
//                }
//                if(!newModel.getType().equals(updatingType)) {
//                    newModel.setType(updatingType);
//                }
//                newModel.setUpdateAt(new Date());
//                newModel.setUpdater("admin");
//            }
//            modelLinkService.update(modelRequest.getName(), newModel.getNodeId(), modelRequest.getClassNodeId());
//            return converter.modelToResponse(modelRepository.save(newModel));
//        } else {
//            throw new ModelNotFoundException();
//        }
//    }
//
//    @Override
//    public ModelResponse delete(String id) throws Throwable {
//        Optional<Well> current = modelRepository.findById(id);
//        if (!current.isPresent()) {
//            throw new ModelNotFoundException();
//        }
//        Well newModel = current.get();
//        modelRepository.delete(newModel);
//        modelLinkService.delete(newModel.getNodeId());
//        return converter.modelToResponse(newModel);
//    }
//
//    @Override
//    public List<ModelResponse> fetchAll(String field, Sort.Direction direction)  throws ModelNotFoundException {
//        List<Well> modelList = modelCustomRepository.fetchAll(field, direction);
//        List<ModelResponse> responseList = modelList.stream().map(x -> converter.modelToResponse(x)).collect(Collectors.toList());
//        return responseList;
//    }
//
//    @Override
//    public Page<ModelResponse> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size) {
//        Page<Well> modelList = modelCustomRepository.fetchAllWithPagination(field, direction, pages, size);
//        Page<ModelResponse> page = new PageImpl<>(modelList.stream().map(x -> converter.modelToResponse(x)).collect(Collectors.toList()));
//        return page;
//    }
//
//    @Override
//    public ModelResponse fetchById(String id) throws ModelNotFoundException {
//        Optional<Well> model = modelRepository.findById(id);
//        if (model.isPresent()) {
//            return converter.modelToResponse(model.get());
//        } else {
//            throw new ModelNotFoundException();
//        }
//    }
//
//    @Override
//    public Document createDoc(String id) throws ModelNotFoundException {
//        ModelResponse modelResponse = fetchById(id);
//        return converter.ResponseToDocument(modelResponse);
//    }
//
//    @Override
//    public ModelResponse create(Document document) throws Throwable {
//        Well model = converter.documentToModel(document);
//        model.setCreateAt(new Date());
//        model.setCreator("admin");
//        Long modelNodeId = modelLinkService.create(model.getName(), (Long) document.get("classNodeId"));
//        model.setNodeId(modelNodeId);
//        return converter.modelToResponse(modelRepository.save(model));
//    }
//
//    @Autowired
//    public void setModelRepository(ModelRepository modelRepository) {
//        this.modelRepository = modelRepository;
//    }
//
//    @Autowired
//    public void setConverter(Converter converter) {
//        this.converter = converter;
//    }
//
//    @Autowired
//    public void setModelLinkService(ModelLinkServiceImpl modelLinkService) {
//        this.modelLinkService = modelLinkService;
//    }
//
//    @Autowired
//    public void setModelCustomRepository(ModelCustomRepository modelCustomRepository) {
//        this.modelCustomRepository = modelCustomRepository;
//    }
    @Autowired
    public void setWellRepository(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }
}
