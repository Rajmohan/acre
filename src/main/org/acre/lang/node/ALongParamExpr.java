/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class ALongParamExpr extends PExpr
{
    private TDollar _dollar_;
    private TLongLiteral _longLiteral_;

    public ALongParamExpr()
    {
    }

    public ALongParamExpr(
        TDollar _dollar_,
        TLongLiteral _longLiteral_)
    {
        setDollar(_dollar_);

        setLongLiteral(_longLiteral_);

    }
    public Object clone()
    {
        return new ALongParamExpr(
            (TDollar) cloneNode(_dollar_),
            (TLongLiteral) cloneNode(_longLiteral_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALongParamExpr(this);
    }

    public TDollar getDollar()
    {
        return _dollar_;
    }

    public void setDollar(TDollar node)
    {
        if(_dollar_ != null)
        {
            _dollar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _dollar_ = node;
    }

    public TLongLiteral getLongLiteral()
    {
        return _longLiteral_;
    }

    public void setLongLiteral(TLongLiteral node)
    {
        if(_longLiteral_ != null)
        {
            _longLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _longLiteral_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_dollar_)
            + toString(_longLiteral_);
    }

    void removeChild(Node child)
    {
        if(_dollar_ == child)
        {
            _dollar_ = null;
            return;
        }

        if(_longLiteral_ == child)
        {
            _longLiteral_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_dollar_ == oldChild)
        {
            setDollar((TDollar) newChild);
            return;
        }

        if(_longLiteral_ == oldChild)
        {
            setLongLiteral((TLongLiteral) newChild);
            return;
        }

    }
}
