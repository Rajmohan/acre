/**
 *   Copyright 2004-2005 Sun Microsystems, Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.acre.visualizer.graph.edges;

import org.acre.visualizer.graph.AcreGraphObject;
import org.acre.visualizer.graph.vertex.AcreVertex;

/**
 * @author Deepak.Alur@Sun.com
 * @version Dec 18, 2004 6:36:29 PM
 */
public interface AcreEdge extends AcreGraphObject {
    public String getEdgeName();
    public void setEdgeName(String edgeName);
    AcreVertex getFromVertex();
    AcreVertex getToVertex();
    AcreVertex getParentVertex();
    void setParentVertex(AcreVertex parentVertex);

    // todo introduce getSourceVertex() and getTargetVertex() methods

}
