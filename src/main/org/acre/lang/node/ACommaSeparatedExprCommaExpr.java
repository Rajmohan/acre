/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class ACommaSeparatedExprCommaExpr extends PCommaExpr
{
    private TBracketL _bracketL_;
    private PUnaryExpr _unaryExpr_;
    private final LinkedList _inlist_ = new TypedLinkedList(new Inlist_Cast());
    private TBracketR _bracketR_;

    public ACommaSeparatedExprCommaExpr()
    {
    }

    public ACommaSeparatedExprCommaExpr(
        TBracketL _bracketL_,
        PUnaryExpr _unaryExpr_,
        List _inlist_,
        TBracketR _bracketR_)
    {
        setBracketL(_bracketL_);

        setUnaryExpr(_unaryExpr_);

        {
            this._inlist_.clear();
            this._inlist_.addAll(_inlist_);
        }

        setBracketR(_bracketR_);

    }

    public ACommaSeparatedExprCommaExpr(
        TBracketL _bracketL_,
        PUnaryExpr _unaryExpr_,
        XPInlist _inlist_,
        TBracketR _bracketR_)
    {
        setBracketL(_bracketL_);

        setUnaryExpr(_unaryExpr_);

        if(_inlist_ != null)
        {
            while(_inlist_ instanceof X1PInlist)
            {
                this._inlist_.addFirst(((X1PInlist) _inlist_).getPInlist());
                _inlist_ = ((X1PInlist) _inlist_).getXPInlist();
            }
            this._inlist_.addFirst(((X2PInlist) _inlist_).getPInlist());
        }

        setBracketR(_bracketR_);

    }
    public Object clone()
    {
        return new ACommaSeparatedExprCommaExpr(
            (TBracketL) cloneNode(_bracketL_),
            (PUnaryExpr) cloneNode(_unaryExpr_),
            cloneList(_inlist_),
            (TBracketR) cloneNode(_bracketR_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommaSeparatedExprCommaExpr(this);
    }

    public TBracketL getBracketL()
    {
        return _bracketL_;
    }

    public void setBracketL(TBracketL node)
    {
        if(_bracketL_ != null)
        {
            _bracketL_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _bracketL_ = node;
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

    public LinkedList getInlist()
    {
        return _inlist_;
    }

    public void setInlist(List list)
    {
        _inlist_.clear();
        _inlist_.addAll(list);
    }

    public TBracketR getBracketR()
    {
        return _bracketR_;
    }

    public void setBracketR(TBracketR node)
    {
        if(_bracketR_ != null)
        {
            _bracketR_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _bracketR_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_bracketL_)
            + toString(_unaryExpr_)
            + toString(_inlist_)
            + toString(_bracketR_);
    }

    void removeChild(Node child)
    {
        if(_bracketL_ == child)
        {
            _bracketL_ = null;
            return;
        }

        if(_unaryExpr_ == child)
        {
            _unaryExpr_ = null;
            return;
        }

        if(_inlist_.remove(child))
        {
            return;
        }

        if(_bracketR_ == child)
        {
            _bracketR_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_bracketL_ == oldChild)
        {
            setBracketL((TBracketL) newChild);
            return;
        }

        if(_unaryExpr_ == oldChild)
        {
            setUnaryExpr((PUnaryExpr) newChild);
            return;
        }

        for(ListIterator i = _inlist_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(_bracketR_ == oldChild)
        {
            setBracketR((TBracketR) newChild);
            return;
        }

    }

    private class Inlist_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PInlist node = (PInlist) o;

            if((node.parent() != null) &&
                (node.parent() != ACommaSeparatedExprCommaExpr.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ACommaSeparatedExprCommaExpr.this))
            {
                node.parent(ACommaSeparatedExprCommaExpr.this);
            }

            return node;
        }
    }
}
