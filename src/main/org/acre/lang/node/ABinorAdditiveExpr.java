/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class ABinorAdditiveExpr extends PAdditiveExpr
{
    private PAdditiveExpr _additiveExpr_;
    private TBinor _binor_;
    private PMultiplicativeExpr _multiplicativeExpr_;

    public ABinorAdditiveExpr()
    {
    }

    public ABinorAdditiveExpr(
        PAdditiveExpr _additiveExpr_,
        TBinor _binor_,
        PMultiplicativeExpr _multiplicativeExpr_)
    {
        setAdditiveExpr(_additiveExpr_);

        setBinor(_binor_);

        setMultiplicativeExpr(_multiplicativeExpr_);

    }
    public Object clone()
    {
        return new ABinorAdditiveExpr(
            (PAdditiveExpr) cloneNode(_additiveExpr_),
            (TBinor) cloneNode(_binor_),
            (PMultiplicativeExpr) cloneNode(_multiplicativeExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABinorAdditiveExpr(this);
    }

    public PAdditiveExpr getAdditiveExpr()
    {
        return _additiveExpr_;
    }

    public void setAdditiveExpr(PAdditiveExpr node)
    {
        if(_additiveExpr_ != null)
        {
            _additiveExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _additiveExpr_ = node;
    }

    public TBinor getBinor()
    {
        return _binor_;
    }

    public void setBinor(TBinor node)
    {
        if(_binor_ != null)
        {
            _binor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _binor_ = node;
    }

    public PMultiplicativeExpr getMultiplicativeExpr()
    {
        return _multiplicativeExpr_;
    }

    public void setMultiplicativeExpr(PMultiplicativeExpr node)
    {
        if(_multiplicativeExpr_ != null)
        {
            _multiplicativeExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _multiplicativeExpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_additiveExpr_)
            + toString(_binor_)
            + toString(_multiplicativeExpr_);
    }

    void removeChild(Node child)
    {
        if(_additiveExpr_ == child)
        {
            _additiveExpr_ = null;
            return;
        }

        if(_binor_ == child)
        {
            _binor_ = null;
            return;
        }

        if(_multiplicativeExpr_ == child)
        {
            _multiplicativeExpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_additiveExpr_ == oldChild)
        {
            setAdditiveExpr((PAdditiveExpr) newChild);
            return;
        }

        if(_binor_ == oldChild)
        {
            setBinor((TBinor) newChild);
            return;
        }

        if(_multiplicativeExpr_ == oldChild)
        {
            setMultiplicativeExpr((PMultiplicativeExpr) newChild);
            return;
        }

    }
}
