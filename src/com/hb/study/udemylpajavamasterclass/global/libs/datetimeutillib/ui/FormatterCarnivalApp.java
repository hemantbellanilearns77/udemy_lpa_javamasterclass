package com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.ui;


import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.core.FormatterMode;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.controller.GUIModeOrchestrator;
import com.hb.study.udemylpajavamasterclass.global.libs.datetimeutillib.core.ZoneLibrary;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;


/**
 * created by : heman on 14-07-2025, 08:49 pm, in the "udemy_lpa_javamasterclass" project
 **/


import java.time.ZoneId;
import java.util.List;

public class FormatterCarnivalApp extends JFrame {

    private JComboBox<FormatterMode> modeCombo;
    private JComboBox<Locale> localeCombo;
    private JComboBox<String> zoneCombo;
    private JTextArea outputArea;

    public FormatterCarnivalApp() {
        setTitle("🎪 Date-Time Formatter Carnival — Diwali Edition");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        modeCombo = new JComboBox<>(FormatterMode.values());
        localeCombo = new JComboBox<>(Locale.getAvailableLocales());


        List<ZoneId> zoneList = ZoneLibrary.getGlobalZones();
        String[] zoneIds = zoneList.stream().map(ZoneId::getId).toArray(String[]::new);
        zoneCombo = new JComboBox<>(zoneIds);
        //zoneCombo.addItem("All");

        JButton runButton = new JButton("🎉 Run Demo");
        JButton customPatternButton = new JButton("🎨 Custom Pattern");
        JButton exportButton = new JButton("📤 Export Log");

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setEditable(false);

        runButton.addActionListener(e -> {
            FormatterLogBuffer.clear();
            FormatterMode selectedMode = (FormatterMode) modeCombo.getSelectedItem();
            Locale selectedLocale = (Locale) localeCombo.getSelectedItem();
            String selectedZoneId = (String) zoneCombo.getSelectedItem();
            //String selectedZoneIdStr = (String) zoneCombo.getSelectedItem();
            //ZoneId selectedZoneId = ZoneId.of(selectedZoneIdStr);
            GUIModeOrchestrator.runMode(selectedMode, selectedLocale, selectedZoneId, null);
            outputArea.setText(FormatterLogBuffer.getLog());
        });

        customPatternButton.addActionListener(e -> {
            String pattern = JOptionPane.showInputDialog(this, "Enter custom date-time pattern:");
            if (pattern != null && !pattern.trim().isEmpty()) {
                FormatterLogBuffer.clear();
                FormatterMode selectedMode = (FormatterMode) modeCombo.getSelectedItem();
                Locale selectedLocale = (Locale) localeCombo.getSelectedItem();
                String selectedZoneId = (String) zoneCombo.getSelectedItem();
                //String selectedZoneIdStr = (String) zoneCombo.getSelectedItem();
                //ZoneId selectedZoneId = ZoneId.of(selectedZoneIdStr);
                GUIModeOrchestrator.runMode(selectedMode, selectedLocale, selectedZoneId, pattern);
                outputArea.setText(FormatterLogBuffer.getLog());
            }
        });

        exportButton.addActionListener(e -> {
            FormatterLogBuffer.exportMarkdown();
            JOptionPane.showMessageDialog(this, "Exported to Markdown view (check console)");
        });

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(new JLabel("Mode:"));
        controlPanel.add(modeCombo);
        controlPanel.add(new JLabel("Locale:"));
        controlPanel.add(localeCombo);
        controlPanel.add(new JLabel("Zone:"));
        controlPanel.add(zoneCombo);
        controlPanel.add(runButton);
        controlPanel.add(customPatternButton);
        controlPanel.add(exportButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormatterCarnivalApp().setVisible(true));
    }
}