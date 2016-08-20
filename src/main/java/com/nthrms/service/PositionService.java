/**
 * 
 */
package com.nthrms.service;

import java.util.List;

import com.nthrms.model.PositionModel;
import com.nthrms.pojo.Position;

/**
 * @author Hoa Nguyen
 * 
 */
public interface PositionService {
    
    List<PositionModel> getAllPosition();
    
    List<PositionModel> getActivedPosition();

    PositionModel getById(Integer id);

    PositionModel getByName(String name);

    Position toPojo(PositionModel positionModel);

    PositionModel toModel(Position position);

    void create(PositionModel positionModel, String[] idList, String[] levelList);

    void edit(PositionModel positionModel, String[] idList, String[] levelList,
	    String[] idPositionList);

    void delete(PositionModel positionModel);

    void clone(PositionModel positionModel, String[] idList, String[] levelList);

    void status(Integer id);
    
    List<PositionModel> search(PositionModel positionModel);

}
