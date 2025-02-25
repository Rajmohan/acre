/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class AStringLiteral extends PLiteral
{
    private TStringLiteral _stringLiteral_;

    public AStringLiteral()
    {
    }

    public AStringLiteral(
        TStringLiteral _stringLiteral_)
    {
        setStringLiteral(_stringLiteral_);

    }
    public Object clone()
    {
        return new AStringLiteral(
            (TStringLiteral) cloneNode(_stringLiteral_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStringLiteral(this);
    }

    public TStringLiteral getStringLiteral()
    {
        return _stringLiteral_;
    }

    public void setStringLiteral(TStringLiteral node)
    {
        if(_stringLiteral_ != null)
        {
            _stringLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _stringLiteral_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_stringLiteral_);
    }

    void removeChild(Node child)
    {
        if(_stringLiteral_ == child)
        {
            _stringLiteral_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_stringLiteral_ == oldChild)
        {
            setStringLiteral((TStringLiteral) newChild);
            return;
        }

    }
}
