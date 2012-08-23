package com.thinkaurelius.faunus.mapreduce;

import com.thinkaurelius.faunus.FaunusVertex;
import com.tinkerpop.blueprints.Query;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ElementCheckerTest extends TestCase {

    public void testCheck() {
        FaunusVertex v1 = new FaunusVertex(1l);
        v1.setProperty("age", 34);

        FaunusVertex v2 = new FaunusVertex(2l);
        v2.setProperty("age", 12);

        FaunusVertex v3 = new FaunusVertex(3l);

        ElementChecker ec = new ElementChecker(false, "age", Query.Compare.EQUAL, 12f, 11f, 15f);
        assertFalse(ec.isLegal(v1));
        assertTrue(ec.isLegal(v2));
        assertFalse(ec.isLegal(v3));
    }
}
