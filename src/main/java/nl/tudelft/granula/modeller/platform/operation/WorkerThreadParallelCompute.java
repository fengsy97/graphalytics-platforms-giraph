/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.tudelft.granula.modeller.platform.operation;

import nl.tudelft.granula.modeller.Type;
import nl.tudelft.granula.modeller.rule.derivation.SimpleSummaryDerivation;
import nl.tudelft.granula.modeller.rule.linking.AdvancedIdentifierParentLinking;
import nl.tudelft.granula.modeller.rule.linking.EmptyLinking;
import nl.tudelft.granula.modeller.rule.linking.IdentifierParentLinking;

public class WorkerThreadParallelCompute extends RealtimeOperationModel {

    public WorkerThreadParallelCompute() {
        super(Type.WorkerThread, Type.ParallelCompute);
    }

    public void loadRules() {
        super.loadRules();

//        addLinkingRule(new UniqueParentLinking(Type.Giraph, Type.Execute));
        addLinkingRule(new AdvancedIdentifierParentLinking(Type.Worker, Type.Ladder, Type.Compute, Type.Equal));
//        addLinkingRule(new EmptyLinking());

        String summary = "ParallelCompute.";
        addInfoDerivation(new SimpleSummaryDerivation(11, summary));
    }
}