using System;
using Avalonia.Controls;
using Avalonia.Controls.Primitives;
using Avalonia.Input;
using Avalonia.Interactivity;

namespace ExperimentWithControls;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        NumberTextBox.AddHandler(TextInputEvent, NumberTextBox_OnTextInput, RoutingStrategies.Tunnel);
    }

    private void NumberTextBox_OnTextChanged(object? sender, TextChangedEventArgs e)
    {
        Number.Text = NumberTextBox.Text;
    }

    private void NumberTextBox_OnTextInput(object? sender, TextInputEventArgs e)
    {
        e.Handled = !int.TryParse(e.Text, out int result);
    }

    private void SmallSlider_OnValueChanged(object? sender, RangeBaseValueChangedEventArgs e)
    {
        if (SmallSlider != null) Number.Text = SmallSlider.Value.ToString("0");
    }

    private void ToggleButton_OnChecked(object? sender, RoutedEventArgs e)
    {
        if (sender is RadioButton radioButton) Number.Text = radioButton.Content?.ToString();
    }

    private void MyListBox_OnSelectionChanged(object? sender, SelectionChangedEventArgs e)
    {
        if (MyListBox.SelectedItem is ListBoxItem listBoxItem)
            Number.Text = listBoxItem.Content?.ToString();
    }

    private void ReadOnlyComboBox_OnSelectionChanged(object? sender, SelectionChangedEventArgs e)
    {
        Console.Write("");
        if (ReadOnlyComboBox.SelectedItem is ListBoxItem listBoxItem)
            Number.Text = listBoxItem.Content?.ToString();
    }
}