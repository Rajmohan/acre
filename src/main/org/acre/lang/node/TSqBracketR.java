/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import org.acre.lang.analysis.*;

public final class TSqBracketR extends Token
{
    public TSqBracketR()
    {
        super.setText("]");
    }

    public TSqBracketR(int line, int pos)
    {
        super.setText("]");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TSqBracketR(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSqBracketR(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TSqBracketR text.");
    }
}
