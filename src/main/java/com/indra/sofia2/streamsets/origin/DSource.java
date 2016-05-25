/*******************************************************************************
 * © Indra Sistemas, S.A.
 * 2013 - 2014  SPAIN
 * 
 * All rights reserved
 ******************************************************************************/
package com.indra.sofia2.streamsets.origin;

import com.streamsets.pipeline.api.BatchMaker;
import com.streamsets.pipeline.api.Source;
import com.streamsets.pipeline.api.Stage;
import com.streamsets.pipeline.api.StageException;

public abstract class DSource extends DStage<Source.Context> implements Source {

  protected abstract Source createSource();

  @Override
  Stage<Source.Context> createStage() {
    return createSource();
  }

  public Source getSource() {
    return (Source)getStage();
  }

  @Override
  public final String produce(String lastSourceOffset, int maxBatchSize, BatchMaker batchMaker) throws StageException {
    return getSource().produce(lastSourceOffset, maxBatchSize, batchMaker);
  }

}
