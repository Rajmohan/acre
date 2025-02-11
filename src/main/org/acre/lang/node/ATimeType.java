/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.acre.lang.node;

import java.util.*;
import org.acre.lang.analysis.*;

public final class ATimeType extends PType
{
    private TTime _time_;

    public ATimeType()
    {
    }

    public ATimeType(
        TTime _time_)
    {
        setTime(_time_);

    }
    public Object clone()
    {
        return new ATimeType(
            (TTime) cloneNode(_time_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATimeType(this);
    }

    public TTime getTime()
    {
        return _time_;
    }

    public void setTime(TTime node)
    {
        if(_time_ != null)
        {
            _time_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _time_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_time_);
    }

    void removeChild(Node child)
    {
        if(_time_ == child)
        {
            _time_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_time_ == oldChild)
        {
            setTime((TTime) newChild);
            return;
        }

    }
}
