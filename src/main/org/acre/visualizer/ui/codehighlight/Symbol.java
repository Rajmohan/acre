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
package org.acre.visualizer.ui.codehighlight;

public class Symbol {
    public int type;
    public String name;
    public Symbol(int type, String name) {
        this.type = type;
        this.name = name;
    }
    public String toString() {
        return name;
    }
    public int hashCode() {
        return name.hashCode() + type;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Symbol)) {
            return false;
        }
        Symbol that = (Symbol) obj;
        return name.equals(that.name) && type == that.type;
    }
}
