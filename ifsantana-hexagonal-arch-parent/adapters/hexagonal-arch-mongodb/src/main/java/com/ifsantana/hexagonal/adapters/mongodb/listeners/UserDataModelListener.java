package com.ifsantana.hexagonal.adapters.mongodb.listeners;

import com.ifsantana.hexagonal.adapters.mongodb.models.UserDataModel;
import com.ifsantana.hexagonal.adapters.mongodb.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserDataModelListener extends AbstractMongoEventListener<UserDataModel> {

  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  public UserDataModelListener(SequenceGeneratorService sequenceGeneratorService) {
    this.sequenceGeneratorService = sequenceGeneratorService;
  }

  @Override
  public void onBeforeConvert(BeforeConvertEvent<UserDataModel> event) {
    if (event.getSource().getId() < 1) {
      event.getSource().setId(sequenceGeneratorService.generateSequence(UserDataModel.SEQUENCE_NAME));
    }
  }
}
