/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.engine.core.dag.actions;

import org.apache.seatunnel.api.source.SeaTunnelSource;
import org.apache.seatunnel.api.source.SourceSplit;

import com.google.common.collect.Lists;
import lombok.NonNull;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

public class SourceAction<T, SplitT extends SourceSplit, StateT extends Serializable> extends AbstractAction {

    private static final long serialVersionUID = -4104531889750766731L;
    private final SeaTunnelSource<T, SplitT, StateT> source;

    public SourceAction(int id,
                        @NonNull String name,
                        @NonNull SeaTunnelSource<T, SplitT, StateT> source,
                        @NonNull List<URL> jarUrls) {
        super(id, name, Lists.newArrayList(), jarUrls);
        this.source = source;
    }

    public SeaTunnelSource<T, SplitT, StateT> getSource() {
        return source;
    }
}