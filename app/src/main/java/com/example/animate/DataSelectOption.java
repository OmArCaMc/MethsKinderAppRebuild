package com.example.animate;

import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

public class DataSelectOption extends ViewModel {
    public final ObservableField<Integer> instruction = new ObservableField<>();
    public final ObservableField<Integer> pathIllustration = new ObservableField<>();
    public final ObservableField<Integer> pathOp1 = new ObservableField<>();
    public final ObservableField<Integer> pathOp2 = new ObservableField<>();
    public final ObservableField<Integer> pathOp3 = new ObservableField<>();
    public int rightOp;
}
