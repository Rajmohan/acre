/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class AFirstTmpInExpr extends PTmpInExpr
{
    private TIdentifier _identifier_;
    private TNot _not_;
    private TIn _in_;
    private PUnaryExpr _unaryExpr_;

    public AFirstTmpInExpr()
    {
    }

    public AFirstTmpInExpr(
        TIdentifier _identifier_,
        TNot _not_,
        TIn _in_,
        PUnaryExpr _unaryExpr_)
    {
        setIdentifier(_identifier_);

        setNot(_not_);

        setIn(_in_);

        setUnaryExpr(_unaryExpr_);

    }
    public Object clone()
    {
        return new AFirstTmpInExpr(
            (TIdentifier) cloneNode(_identifier_),
            (TNot) cloneNode(_not_),
            (TIn) cloneNode(_in_),
            (PUnaryExpr) cloneNode(_unaryExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFirstTmpInExpr(this);
    }

    public TIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public TNot getNot()
    {
        return _not_;
    }

    public void setNot(TNot node)
    {
        if(_not_ != null)
        {
            _not_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _not_ = node;
    }

    public TIn getIn()
    {
        return _in_;
    }

    public void setIn(TIn node)
    {
        if(_in_ != null)
        {
            _in_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _in_ = node;
    }

    public PUnaryExpr getUnaryExpr()
    {
        return _unaryExpr_;
    }

    public void setUnaryExpr(PUnaryExpr node)
    {
        if(_unaryExpr_ != null)
        {
            _unaryExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unaryExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_identifier_)
            + toString(_not_)
            + toString(_in_)
            + toString(_unaryExpr_);
    }

    void removeChild(Node child)
    {
        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

        if(_not_ == child)
        {
            _not_ = null;
            return;
        }

        if(_in_ == child)
        {
            _in_ = null;
            return;
        }

        if(_unaryExpr_ == child)
        {
            _unaryExpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(_not_ == oldChild)
        {
            setNot((TNot) newChild);
            return;
        }

        if(_in_ == oldChild)
        {
            setIn((TIn) newChild);
            return;
        }

        if(_unaryExpr_ == oldChild)
        {
            setUnaryExpr((PUnaryExpr) newChild);
            return;
        }

    }
}
