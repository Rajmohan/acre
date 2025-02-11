/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class ABothEqneTmpEqualityExpr extends PTmpEqualityExpr
{
    private TIdentifier _left_;
    private PEqne _eqne_;
    private TIdentifier _right_;

    public ABothEqneTmpEqualityExpr()
    {
    }

    public ABothEqneTmpEqualityExpr(
        TIdentifier _left_,
        PEqne _eqne_,
        TIdentifier _right_)
    {
        setLeft(_left_);

        setEqne(_eqne_);

        setRight(_right_);

    }
    public Object clone()
    {
        return new ABothEqneTmpEqualityExpr(
            (TIdentifier) cloneNode(_left_),
            (PEqne) cloneNode(_eqne_),
            (TIdentifier) cloneNode(_right_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABothEqneTmpEqualityExpr(this);
    }

    public TIdentifier getLeft()
    {
        return _left_;
    }

    public void setLeft(TIdentifier node)
    {
        if(_left_ != null)
        {
            _left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _left_ = node;
    }

    public PEqne getEqne()
    {
        return _eqne_;
    }

    public void setEqne(PEqne node)
    {
        if(_eqne_ != null)
        {
            _eqne_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _eqne_ = node;
    }

    public TIdentifier getRight()
    {
        return _right_;
    }

    public void setRight(TIdentifier node)
    {
        if(_right_ != null)
        {
            _right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _right_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_left_)
            + toString(_eqne_)
            + toString(_right_);
    }

    void removeChild(Node child)
    {
        if(_left_ == child)
        {
            _left_ = null;
            return;
        }

        if(_eqne_ == child)
        {
            _eqne_ = null;
            return;
        }

        if(_right_ == child)
        {
            _right_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_left_ == oldChild)
        {
            setLeft((TIdentifier) newChild);
            return;
        }

        if(_eqne_ == oldChild)
        {
            setEqne((PEqne) newChild);
            return;
        }

        if(_right_ == oldChild)
        {
            setRight((TIdentifier) newChild);
            return;
        }

    }
}
