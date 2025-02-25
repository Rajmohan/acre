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
package org.acre.lang.application;

import org.acre.lang.TreeBuilder;
import org.acre.lang.node.Node;
import org.acre.lang.tool.Version;

import java.io.FileReader;


/**
 * Prints the tree of the given OQL file on standard output.
 * This is a toy class which demonstrates the use of
 * PrintWalker adapter for traversing the tree.
 *
 * @author Mariusz Nowostawski
 * @version @version@ $Revision: 1.1.1.1 $
 */
public class PrintTree {

    public static void main(String[] arguments) {

        System.out.println(Version.banner());

        if (arguments.length != 1) {
            System.out.println("usage:");
            System.out.println("  java PrintTree filename");
            System.exit(1);
        }

        try {
            Node ast = TreeBuilder.getNode(new FileReader(arguments[0]), true);//simple tree
            ast.apply(new PrintWalker());
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

}


