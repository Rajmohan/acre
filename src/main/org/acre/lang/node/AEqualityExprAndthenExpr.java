/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class AEqualityExprAndthenExpr extends PAndthenExpr
{
    private PTmpEqualityExpr _tmpEqualityExpr_;

    public AEqualityExprAndthenExpr()
    {
    }

    public AEqualityExprAndthenExpr(
        PTmpEqualityExpr _tmpEqualityExpr_)
    {
        setTmpEqualityExpr(_tmpEqualityExpr_);

    }
    public Object clone()
    {
        return new AEqualityExprAndthenExpr(
            (PTmpEqualityExpr) cloneNode(_tmpEqualityExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqualityExprAndthenExpr(this);
    }

    public PTmpEqualityExpr getTmpEqualityExpr()
    {
        return _tmpEqualityExpr_;
    }

    public void setTmpEqualityExpr(PTmpEqualityExpr node)
    {
        if(_tmpEqualityExpr_ != null)
        {
            _tmpEqualityExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tmpEqualityExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tmpEqualityExpr_);
    }

    void removeChild(Node child)
    {
        if(_tmpEqualityExpr_ == child)
        {
            _tmpEqualityExpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tmpEqualityExpr_ == oldChild)
        {
            setTmpEqualityExpr((PTmpEqualityExpr) newChild);
            return;
        }

    }
}
