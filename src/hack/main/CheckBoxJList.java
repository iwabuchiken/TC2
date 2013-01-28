package hack.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class CheckBoxJList extends JList
    implements ListSelectionListener {

//	static JFrame frame;
	
    static Color listForeground, listBackground,
        listSelectionForeground,
        listSelectionBackground;

	private static JButton btnTime;

    static {
        UIDefaults uid = UIManager.getLookAndFeel().getDefaults();
        listForeground =  uid.getColor ("List.foreground");
        listBackground =  uid.getColor ("List.background");
        listSelectionForeground =  uid.getColor ("List.selectionForeground");
        listSelectionBackground =  uid.getColor ("List.selectionBackground");
    }//static

    HashSet selectionCache = new HashSet();
    
    int toggleIndex = -1;
    
    boolean toggleWasSelected;

    public CheckBoxJList() {
        super();
        
        //debug
        setName("ABCDE");
        /////////////////////////
        
        setCellRenderer (new CheckBoxListCellRenderer());
        addListSelectionListener (this);
    }//public CheckBoxJList()

    // ListSelectionListener implementation
    public void valueChanged (ListSelectionEvent lse) {
    
    	System.out.println (lse);
        
    	if (! lse.getValueIsAdjusting()) {
            removeListSelectionListener (this);

            // remember everything selected as a result of this action
            HashSet newSelections = new HashSet();
            int size = getModel().getSize();
            for (int i=0; i<size; i++) {
                if (getSelectionModel().isSelectedIndex(i)) {
                    newSelections.add (new Integer(i));
                }
            }

            // turn on everything that was previously selected
            Iterator it = selectionCache.iterator();
            while (it.hasNext()) {
                int index = ((Integer) it.next()).intValue();
                System.out.println ("adding " + index);
                getSelectionModel().addSelectionInterval(index, index);
            }

            // add or remove the delta
            it = newSelections.iterator();
            while (it.hasNext()) {
                Integer nextInt = (Integer) it.next();
                int index = nextInt.intValue();
                if (selectionCache.contains (nextInt))
                    getSelectionModel().removeSelectionInterval (index, index);
                else
                    getSelectionModel().addSelectionInterval (index, index);
            }

            // save selections for next time
            selectionCache.clear();
            for (int i=0; i<size; i++) {
                if (getSelectionModel().isSelectedIndex(i)) {
                    System.out.println ("caching " + i);
                    selectionCache.add (new Integer(i));
                }
            }

            addListSelectionListener (this);

        }//if (! lse.getValueIsAdjusting())
    }//public void valueChanged (ListSelectionEvent lse)




    public static void main (String[] args) {
    	
//    	debugs_B4();
    	
        JList list = new CheckBoxJList ();
        
        DefaultListModel defModel = new DefaultListModel();
        list.setModel (defModel);
        
        String[] listItems = {
            "Chris", "Joshua", "Daniel", "Michael",
            "Don", "Kimi", "Kelly", "Keagan"
        };
        
        Iterator it = Arrays.asList(listItems).iterator();
        
        while (it.hasNext())
            defModel.addElement (it.next());
        
        // show list
        JScrollPane scroller =
            new JScrollPane (list,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JFrame frame = new JFrame ("Checkbox JList");
//        frame = new JFrame ("Checkbox JList");
        
    	debugs_B4(frame);
    	
        frame.getContentPane().add (scroller);
        
//        frame.pack();
        
        frame.setVisible(true);
    }


    private static void debugs_B4(JFrame frame) {
		// TODO 自動生成されたメソッド・スタブ
//    	debug_B4_v_1_0();
//    	debug_B4_v_1_0_2_getColor();
//    	debug_B4_v_1_0_3_ScrollPaneConstants();
//    	debug_B4_v_2_0_1_addButtons(frame);

	}//private static void debugs_B4()

	private static void debug_B4_v_2_0_1_addButtons(JFrame frame) {
		// TODO 自動生成されたメソッド・スタブ
        //debug =========================
		frame.setLayout(new BorderLayout());
//        frame.getContentPane().setLayout(new BorderLayout());
		
		
		////////////////////////////debug
        frame.setSize(200, 200);
        
//		btnTime = new JButton("Get");
//		
//		btnTime.setBounds(20, 20, 70, 40);
//
//		frame.getContentPane().add(btnTime);
        
		
	}//private static void debug_B4_v_2_0_1_addButtons()

	private static void debug_B4_v_1_0_3_ScrollPaneConstants() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS="
					+ String.valueOf(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS));

		System.out.println("ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER="
				+ String.valueOf(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

	}

	private static void debug_B4_v_1_0_2_getColor() {
		// TODO 自動生成されたメソッド・スタブ
		UIDefaults uid = UIManager.getLookAndFeel().getDefaults();
		Color col = uid.getColor ("List.foreground");
		
		System.out.println("col.getAlpha()=" + String.valueOf(col.getAlpha()));
		System.out.println("col.getBlue()=" + String.valueOf(col.getBlue()));
		System.out.println("col.getGreen()=" + String.valueOf(col.getGreen()));
		System.out.println("col.getRed()=" + String.valueOf(col.getRed()));
				
	}

	private static void debug_B4_v_1_0() {
		// TODO 自動生成されたメソッド・スタブ
    	//debug
    	UIDefaults uid = UIManager.getLookAndFeel().getDefaults();
//    	Set<String> keySet = (Set<String>) uid.keySet();
//    	String[] keys = (String[]) uid.keySet().toArray(new String[0]);
//    	String[] keys = (String[]) uid.keySet().toArray();
    	Object[] keys = (Object[]) uid.keySet().toArray();
    	
//    	for (String key : keys) {
    	for (Object key : keys) {
			
//    		System.out.println("key=" + (String)key);	//=> Exception in thread "main" java.lang.ClassCastException: java.lang.StringBuffer cannot be cast to java.lang.String
//    		System.out.println("key=" + key);
    		System.out.println("key=" + key.toString());
    		
		}//for (elemType keys : source)
    	
    	//Result
//    	key=TabbedPane.textIconGap
//    			key=ButtonUI
//    			key=RootPane.questionDialogBorder
//    			key=FormattedTextField.margin
//    			key=RootPane.colorChooserDialogBorder
//    			key=DesktopIcon.foreground
//    			key=CheckBoxMenuItem.border
//    			key=TabbedPane.contentOpaque
//    			key=OptionPane.errorDialog.titlePane.foreground
//    			key=TextArea.background
//    			key=Spinner.ancestorInputMap
//    			key=activeCaption
//    			key=PasswordField.inactiveForeground
//    			key=RootPane.plainDialogBorder
//    			key=TabbedPane.focus
//    			key=RadioButton.disabledText
//    			key=TabbedPane.contentAreaColor
//    			key=Table.dropCellBackground
//    			key=SplitPaneUI
//    			key=MenuItem.acceleratorForeground
//    			key=Slider.horizontalSize
//    			key=EditorPane.caretForeground
//    			key=ProgressBar.cycleTime
//    			key=Table.background
//    			key=Menu.selectionForeground
//    			key=ToggleButton.focusInputMap
//    			key=FileChooser.upFolderIcon
//    			key=OptionPane.errorDialog.border.background
//    			key=Tree.focusInputMap.RightToLeft
//    			key=PasswordField.echoChar
//    			key=ToolBar.floatingBackground
//    			key=ToggleButton.margin
//    			key=RadioButtonMenuItem.selectionBackground
//    			key=DesktopIcon.background
//    			key=CheckBoxMenuItem.selectionForeground
//    			key=AuditoryCues.allAuditoryCues
//    			key=List.dropLineColor
//    			key=TabbedPane.unselectedBackground
//    			key=List.font
//    			key=Spinner.arrowButtonBorder
//    			key=InternalFrame.borderColor
//    			key=Slider.minimumVerticalSize
//    			key=CheckBox.foreground
//    			key=RootPane.fileChooserDialogBorder
//    			key=ProgressBar.foreground
//    			key=InternalFrameUI
//    			key=OptionPane.buttonClickThreshhold
//    			key=ComboBox.disabledForeground
//    			key=OptionPane.windowBindings
//    			key=TableHeader.font
//    			key=MenuBar.gradient
//    			key=textInactiveText
//    			key=OptionPane.warningDialog.titlePane.foreground
//    			key=Slider.highlight
//    			key=FormattedTextField.caretForeground
//    			key=RadioButtonMenuItemUI
//    			key=ToolTip.border
//    			key=InternalFrameTitlePane.maximizeButtonOpacity
//    			key=Slider.onlyLeftMouseButtonDrag
//    			key=FileChooser.ancestorInputMap
//    			key=Menu.selectionBackground
//    			key=FileChooser.newFolderIcon
//    			key=ScrollBar.minimumThumbSize
//    			key=Tree.focusInputMap
//    			key=TextField.caretForeground
//    			key=InternalFrame.maximizeSound
//    			key=ToolBar.border
//    			key=Panel.font
//    			key=ScrollBar.width
//    			key=OptionPane.messageForeground
//    			key=RadioButton.highlight
//    			key=ToolBar.shadow
//    			key=CheckBoxMenuItem.selectionBackground
//    			key=Menu.acceleratorForeground
//    			key=TextArea.font
//    			key=ProgressBar.repaintInterval
//    			key=Label.foreground
//    			key=text
//    			key=ToggleButton.font
//    			key=ScrollBar.gradient
//    			key=RadioButtonUI
//    			key=InternalFrame.iconifyIcon
//    			key=ComboBox.disabledBackground
//    			key=Tree.ancestorInputMap
//    			key=Button.focus
//    			key=ToolTip.hideAccelerator
//    			key=RootPane.ancestorInputMap
//    			key=ComboBox.font
//    			key=Tree.changeSelectionWithFocus
//    			key=PopupMenuSeparatorUI
//    			key=ToggleButton.gradient
//    			key=inactiveCaptionText
//    			key=MenuBar.background
//    			key=PasswordField.selectionForeground
//    			key=CheckBoxMenuItem.acceleratorSelectionForeground
//    			key=ScrollBar.ancestorInputMap
//    			key=controlShadow
//    			key=menu
//    			key=inactiveCaptionBorder
//    			key=ScrollPane.font
//    			key=InternalFrame.restoreDownSound
//    			key=PasswordField.foreground
//    			key=TextPane.foreground
//    			key=ProgressBar.cellLength
//    			key=TabbedPane.tabAreaBackground
//    			key=TextArea.margin
//    			key=Viewport.foreground
//    			key=OptionPane.questionIcon
//    			key=TabbedPane.foreground
//    			key=ToggleButton.focus
//    			key=RadioButton.foreground
//    			key=RadioButton.icon
//    			key=infoText
//    			key=TabbedPane.selected
//    			key=CheckBoxMenuItem.gradient
//    			key=RadioButton.textShiftOffset
//    			key=MenuBar.highlight
//    			key=ScrollBar.highlight
//    			key=OptionPane.border
//    			key=Menu.submenuPopupOffsetY
//    			key=ScrollPaneUI
//    			key=InternalFrame.inactiveTitleBackground
//    			key=Menu.submenuPopupOffsetX
//    			key=CheckBoxMenuItem.commandSound
//    			key=OptionPane.questionSound
//    			key=ScrollBar.thumbDarkShadow
//    			key=CheckBox.border
//    			key=CheckBox.totalInsets
//    			key=ToolBar.light
//    			key=EditorPane.inactiveForeground
//    			key=OptionPane.errorDialog.titlePane.background
//    			key=RootPaneUI
//    			key=PasswordField.background
//    			key=Menu.preserveTopLevelSelection
//    			key=TextPane.background
//    			key=RadioButton.select
//    			key=PasswordField.inactiveBackground
//    			key=Spinner.font
//    			key=Button.toolBarBorderBackground
//    			key=MenuItem.foreground
//    			key=FileChooserUI
//    			key=TableHeader.focusCellBackground
//    			key=RadioButtonMenuItem.font
//    			key=ToolBarSeparatorUI
//    			key=FileView.fileIcon
//    			key=Slider.font
//    			key=OptionPane.informationIcon
//    			key=RadioButton.background
//    			key=ScrollBar.allowsAbsolutePositioning
//    			key=ToolBar.borderColor
//    			key=RadioButtonMenuItem.checkIcon
//    			key=Menu.crossMenuMnemonic
//    			key=inactiveCaption
//    			key=RootPane.informationDialogBorder
//    			key=ScrollBar.trackHighlight
//    			key=OptionPane.messageAreaBorder
//    			key=Tree.leftChildIndent
//    			key=OptionPane.questionDialog.titlePane.foreground
//    			key=LabelUI
//    			key=Table.focusCellHighlightBorder
//    			key=SliderUI
//    			key=Tree.textForeground
//    			key=TableHeader.foreground
//    			key=CheckBox.background
//    			key=Slider.focusInputMap.RightToLeft
//    			key=ProgressBar.background
//    			key=Desktop.ancestorInputMap
//    			key=FileView.floppyDriveIcon
//    			key=Menu.cancelMode
//    			key=EditorPane.font
//    			key=InternalFrame.closeSound
//    			key=Label.disabledForeground
//    			key=OptionPane.warningDialog.titlePane.background
//    			key=ToggleButton.highlight
//    			key=Slider.verticalThumbIcon
//    			key=ScrollPane.foreground
//    			key=EditorPane.border
//    			key=TextArea.caretForeground
//    			key=FileChooser.usesSingleFilePane
//    			key=DesktopIcon.border
//    			key=Label.background
//    			key=OptionPane.font
//    			key=TabbedPane.selectedLabelShift
//    			key=RadioButtonMenuItem.border
//    			key=Spinner.foreground
//    			key=Slider.tickColor
//    			key=Tree.textBackground
//    			key=InternalFrame.closeIcon
//    			key=TreeUI
//    			key=OptionPane.errorIcon
//    			key=InternalFrame.borderLight
//    			key=TabbedPane.tabRunOverlay
//    			key=textHighlightText
//    			key=Separator.shadow
//    			key=CheckBoxMenuItem.disabledForeground
//    			key=CheckBoxMenuItem.arrowIcon
//    			key=ComboBox.isEnterSelectablePopup
//    			key=controlText
//    			key=InternalFrame.borderDarkShadow
//    			key=OptionPane.warningSound
//    			key=TextField.border
//    			key=Tree.closedIcon
//    			key=ScrollBarUI
//    			key=TextField.shadow
//    			key=PasswordField.selectionBackground
//    			key=Spinner.background
//    			key=TabbedPane.shadow
//    			key=Slider.gradient
//    			key=RadioButton.margin
//    			key=desktop
//    			key=Tree.dropLineColor
//    			key=PopupMenu.popupSound
//    			key=InternalFrame.minimizeIcon
//    			key=RadioButton.textIconGap
//    			key=FileChooser.homeFolderIcon
//    			key=OptionPane.questionDialog.titlePane.shadow
//    			key=TabbedPane.darkShadow
//    			key=Viewport.background
//    			key=CheckBox.disabledText
//    			key=ComboBox.foreground
//    			key=FileView.computerIcon
//    			key=RadioButton.darkShadow
//    			key=ToolBar.font
//    			key=TabbedPane.background
//    			key=TabbedPane.ancestorInputMap
//    			key=OptionPane.warningDialog.titlePane.shadow
//    			key=ToggleButtonUI
//    			key=ToolTip.borderInactive
//    			key=SplitPane.ancestorInputMap
//    			key=TextPane.margin
//    			key=activeCaptionBorder
//    			key=AATextInfoPropertyKey
//    			key=html.pendingImage
//    			key=OptionPane.minimumSize
//    			key=PopupMenu.consumeEventOnClose
//    			key=RadioButton.focusInputMap
//    			key=TabbedPane.focusInputMap
//    			key=InternalFrame.borderShadow
//    			key=Tree.leafIcon
//    			key=MenuItem.selectionForeground
//    			key=Tree.font
//    			key=TextArea.selectionForeground
//    			key=MenuItem.background
//    			key=CheckBoxMenuItem.margin
//    			key=CheckBoxMenuItem.font
//    			key=InternalFrame.border
//    			key=ViewportUI
//    			key=TitledBorder.font
//    			key=ComboBox.buttonShadow
//    			key=ScrollBar.track
//    			key=ScrollBar.thumb
//    			key=TextField.caretBlinkRate
//    			key=MenuItem.acceleratorDelimiter
//    			key=TabbedPane.tabInsets
//    			key=DesktopIcon.width
//    			key=InternalFrame.paletteCloseIcon
//    			key=Button.focusInputMap
//    			key=Tree.openIcon
//    			key=MenuItem.acceleratorSelectionForeground
//    			key=Table.dropLineColor
//    			key=control
//    			key=TextFieldUI
//    			key=Tree.lineTypeDashed
//    			key=OptionPane.questionDialog.titlePane.background
//    			key=Panel.foreground
//    			key=TabbedPane.light
//    			key=DesktopIconUI
//    			key=Table.font
//    			key=MenuBar.font
//    			key=Menu.checkIcon
//    			key=MenuItem.selectionBackground
//    			key=RootPane.errorDialogBorder
//    			key=MenuItem.checkIcon
//    			key=Label.disabledShadow
//    			key=ToolTip.foreground
//    			key=TableHeader.background
//    			key=EditorPane.selectionForeground
//    			key=List.foreground
//    			key=FileChooser.filesOfTypeLabelMnemonic
//    			key=OptionPane.warningDialog.border.background
//    			key=Desktop.background
//    			key=PasswordFieldUI
//    			key=PopupMenu.font
//    			key=ColorChooser.swatchesRecentSwatchSize
//    			key=ScrollPane.background
//    			key=ColorChooser.swatchesSwatchSize
//    			key=PasswordField.focusInputMap
//    			key=Spinner.editorBorderPainted
//    			key=activeCaptionText
//    			key=PopupMenu.selectedWindowInputMapBindings.RightToLeft
//    			key=SplitPane.dividerFocusColor
//    			key=DesktopIcon.font
//    			key=Tree.foreground
//    			key=InternalFrame.paletteBorder
//    			key=ComboBox.ancestorInputMap
//    			key=ScrollBar.ancestorInputMap.RightToLeft
//    			key=SplitPane.highlight
//    			key=OptionPane.informationSound
//    			key=TextField.foreground
//    			key=ToolBar.nonrolloverBorder
//    			key=PasswordField.border
//    			key=Tree.timeFactor
//    			key=CheckBoxMenuItemUI
//    			key=SpinnerUI
//    			key=TableHeaderUI
//    			key=CheckBox.textShiftOffset
//    			key=ProgressBar.verticalSize
//    			key=MenuItem.commandSound
//    			key=ScrollBar.thumbShadow
//    			key=TextArea.inactiveForeground
//    			key=ToolTip.foregroundInactive
//    			key=Tree.hash
//    			key=Slider.verticalSize
//    			key=FormattedTextField.selectionForeground
//    			key=InternalFrame.restoreUpSound
//    			key=TableUI
//    			key=textText
//    			key=RadioButton.focus
//    			key=ToggleButton.disabledText
//    			key=html.missingImage
//    			key=ComboBox.timeFactor
//    			key=Tree.background
//    			key=ScrollPane.ancestorInputMap
//    			key=FileView.hardDriveIcon
//    			key=TableHeader.ancestorInputMap
//    			key=RadioButtonMenuItem.disabledForeground
//    			key=Tree.expandedIcon
//    			key=Button.rollover
//    			key=TextField.background
//    			key=TextPane.focusInputMap
//    			key=ColorChooser.foreground
//    			key=Button.defaultButtonFollowsFocus
//    			key=TabbedPaneUI
//    			key=Label.font
//    			key=Button.light
//    			key=Button.border
//    			key=Button.disabledToolBarBorderBackground
//    			key=ColorChooser.swatchesDefaultRecentColor
//    			key=FileView.directoryIcon
//    			key=SplitPane.oneTouchButtonsOpaque
//    			key=ComboBox.background
//    			key=Button.shadow
//    			key=ToggleButton.textShiftOffset
//    			key=ProgressBar.cellSpacing
//    			key=Button.foreground
//    			key=Table.focusCellForeground
//    			key=OptionPane.errorSound
//    			key=Table.gridColor
//    			key=Menu.opaque
//    			key=DesktopPaneUI
//    			key=FormattedTextFieldUI
//    			key=CheckBox.textIconGap
//    			key=PasswordField.caretForeground
//    			key=TextPane.selectionForeground
//    			key=Spinner.border
//    			key=menuText
//    			key=SplitPaneDivider.draggingColor
//    			key=MenuItem.font
//    			key=InternalFrame.borderHighlight
//    			key=CheckBox.margin
//    			key=MenuItem.borderPainted
//    			key=TextArea.selectionBackground
//    			key=EditorPane.focusInputMap
//    			key=ToggleButton.light
//    			key=Table.descendingSortIcon
//    			key=controlDkShadow
//    			key=TextField.light
//    			key=CheckBoxUI
//    			key=ListUI
//    			key=Button.background
//    			key=ProgressBarUI
//    			key=List.timeFactor
//    			key=TabbedPane.contentBorderInsets
//    			key=TextField.selectionForeground
//    			key=TabbedPane.selectionFollowsFocus
//    			key=Separator.foreground
//    			key=ToolBar.dockingForeground
//    			key=TextPane.selectionBackground
//    			key=Panel.background
//    			key=PasswordField.caretBlinkRate
//    			key=Spinner.arrowButtonSize
//    			key=ToolTip.background
//    			key=Button.gradient
//    			key=EditorPane.selectionBackground
//    			key=List.background
//    			key=SplitPane.border
//    			key=TextPane.inactiveForeground
//    			key=MenuItem.acceleratorFont
//    			key=Slider.majorTickLength
//    			key=SplitPane.shadow
//    			key=TextField.focusInputMap
//    			key=TextField.selectionBackground
//    			key=Menu.border
//    			key=Menu.disabledForeground
//    			key=ToolBar.dockingBackground
//    			key=FormattedTextField.focusInputMap
//    			key=Tree.collapsedIcon
//    			key=PanelUI
//    			key=List.selectionForeground
//    			key=TextField.inactiveForeground
//    			key=SeparatorUI
//    			key=MenuItem.border
//    			key=EditorPane.margin
//    			key=window
//    			key=TextField.darkShadow
//    			key=OptionPane.buttonAreaBorder
//    			key=Slider.focusInsets
//    			key=Tree.dropCellBackground
//    			key=OptionPane.errorDialog.titlePane.shadow
//    			key=TextField.font
//    			key=CheckBox.rollover
//    			key=RadioButtonMenuItem.margin
//    			key=Menu.menuPopupOffsetY
//    			key=Menu.menuPopupOffsetX
//    			key=TextPane.font
//    			key=List.focusCellHighlightBorder
//    			key=OptionPane.warningIcon
//    			key=TabbedPane.borderHightlightColor
//    			key=RadioButtonMenuItem.acceleratorSelectionForeground
//    			key=ComboBox.selectionForeground
//    			key=ScrollPane.border
//    			key=FormattedTextField.selectionBackground
//    			key=Tree.selectionBorderColor
//    			key=ToggleButton.textIconGap
//    			key=Tree.selectionForeground
//    			key=Slider.foreground
//    			key=CheckBox.font
//    			key=Slider.trackWidth
//    			key=TabbedPane.selectHighlight
//    			key=MenuBar.borderColor
//    			key=ScrollBar.thumbHighlight
//    			key=InternalFrame.maximizeIcon
//    			key=TextField.highlight
//    			key=TextField.inactiveBackground
//    			key=MenuBar.shadow
//    			key=RootPane.warningDialogBorder
//    			key=InternalFrame.icon
//    			key=TextPane.caretForeground
//    			key=TextField.margin
//    			key=ComboBoxUI
//    			key=Table.selectionForeground
//    			key=ColorChooser.background
//    			key=ScrollPane.ancestorInputMap.RightToLeft
//    			key=ToggleButton.border
//    			key=ToggleButton.shadow
//    			key=Button.darkShadow
//    			key=ComboBox.buttonDarkShadow
//    			key=Table.ancestorInputMap.RightToLeft
//    			key=FileChooser.listViewIcon
//    			key=Table.focusCellBackground
//    			key=ComboBox.buttonBackground
//    			key=SplitPane.centerOneTouchButtons
//    			key=Tree.rightChildIndent
//    			key=ToggleButton.foreground
//    			key=PopupMenu.border
//    			key=Tree.line
//    			key=ToolTipUI
//    			key=Tree.drawsFocusBorderAroundIcon
//    			key=InternalFrame.minimizeSound
//    			key=windowText
//    			key=FormattedTextField.inactiveForeground
//    			key=scrollbar
//    			key=InternalFrameTitlePane.closeButtonOpacity
//    			key=Table.scrollPaneBorder
//    			key=CheckBox.gradient
//    			key=InternalFrame.optionDialogBorder
//    			key=TabbedPane.tabsOverlapBorder
//    			key=List.cellRenderer
//    			key=FileChooser.lookInLabelMnemonic
//    			key=controlLtHighlight
//    			key=SplitPane.darkShadow
//    			key=Button.select
//    			key=ScrollBar.shadow
//    			key=Tree.paintLines
//    			key=AuditoryCues.noAuditoryCues
//    			key=SplitPane.background
//    			key=FileChooser.detailsViewIcon
//    			key=ProgressBar.font
//    			key=RadioButtonMenuItem.gradient
//    			key=controlHighlight
//    			key=Separator.background
//    			key=CheckBoxMenuItem.foreground
//    			key=Menu.borderPainted
//    			key=FormattedTextField.inactiveBackground
//    			key=ScrollBar.maximumThumbSize
//    			key=FormattedTextField.foreground
//    			key=Table.ascendingSortIcon
//    			key=Spinner.arrowButtonInsets
//    			key=List.noFocusBorder
//    			key=RootPane.defaultButtonWindowKeyBindings
//    			key=FormattedTextField.font
//    			key=FormattedTextField.border
//    			key=textHighlight
//    			key=FormattedTextField.caretBlinkRate
//    			key=Slider.horizontalThumbIcon
//    			key=Button.highlight
//    			key=CheckBoxMenuItem.acceleratorFont
//    			key=Menu.shortcutKeys
//    			key=Button.textIconGap
//    			key=TabbedPane.tabsOpaque
//    			key=AuditoryCues.cueList
//    			key=Table.sortIconColor
//    			key=TextArea.border
//    			key=MenuBar.border
//    			key=CheckBoxMenuItem.background
//    			key=List.selectionBackground
//    			key=Menu.acceleratorFont
//    			key=TitledBorder.titleColor
//    			key=TableHeader.cellBorder
//    			key=ToolBar.isRollover
//    			key=ColorChooser.font
//    			key=RootPane.frameBorder
//    			key=InternalFrameTitlePane.iconifyButtonOpacity
//    			key=ProgressBar.selectionForeground
//    			key=TabbedPane.tabAreaInsets
//    			key=OptionPaneUI
//    			key=Table.dropLineShortColor
//    			key=List.focusInputMap
//    			key=CheckBoxMenuItem.checkIcon
//    			key=EditorPane.foreground
//    			key=MenuItem.disabledForeground
//    			key=CheckBox.focus
//    			key=TitledBorder.border
//    			key=Slider.focusInputMap
//    			key=ProgressBar.horizontalSize
//    			key=Tree.rowHeight
//    			key=Menu.font
//    			key=Slider.focus
//    			key=PopupMenu.selectedWindowInputMapBindings
//    			key=FileChooser.useSystemExtensionHiding
//    			key=ComboBox.selectionBackground
//    			key=InternalFrame.activeTitleForeground
//    			key=ToolBar.separatorSize
//    			key=PasswordField.margin
//    			key=Tree.selectionBackground
//    			key=ToolBar.ancestorInputMap
//    			key=Slider.background
//    			key=MenuBarUI
//    			key=RadioButtonMenuItem.arrowIcon
//    			key=TextArea.foreground
//    			key=List.focusInputMap.RightToLeft
//    			key=FileChooser.fileNameLabelMnemonic
//    			key=ComboBox.buttonHighlight
//    			key=Button.rolloverIconType
//    			key=Separator.highlight
//    			key=FileChooser.readOnly
//    			key=PasswordField.font
//    			key=RadioButton.rollover
//    			key=PopupMenu.foreground
//    			key=Table.ancestorInputMap
//    			key=ProgressBar.selectionBackground
//    			key=ScrollBar.foreground
//    			key=OptionPane.foreground
//    			key=Table.selectionBackground
//    			key=ToolBar.rolloverBorder
//    			key=ColorChooserUI
//    			key=ToolTipManager.enableToolTipMode
//    			key=TextArea.focusInputMap
//    			key=Button.textShiftOffset
//    			key=TextArea.caretBlinkRate
//    			key=TabbedPane.labelShift
//    			key=InternalFrame.titleFont
//    			key=info
//    			key=Slider.focusGradient
//    			key=RadioButtonMenuItem.acceleratorFont
//    			key=InternalFrame.activeTitleBackground
//    			key=RadioButton.light
//    			key=Button.margin
//    			key=ToolBar.floatingForeground
//    			key=RadioButtonMenuItem.selectionForeground
//    			key=ProgressBar.border
//    			key=ToggleButton.darkShadow
//    			key=windowBorder
//    			key=ToggleButton.background
//    			key=CheckBox.icon
//    			key=CheckBox.focusInputMap
//    			key=TabbedPane.highlight
//    			key=ScrollBar.darkShadow
//    			key=PopupMenu.background
//    			key=ToolBarUI
//    			key=Viewport.font
//    			key=Slider.altTrackColor
//    			key=ScrollBar.background
//    			key=Menu.arrowIcon
//    			key=MenuItem.arrowIcon
//    			key=Menu.acceleratorSelectionForeground
//    			key=OptionPane.background
//    			key=Desktop.minOnScreenInsets
//    			key=Checkbox.select
//    			key=Menu.foreground
//    			key=Tree.editorBorder
//    			key=AuditoryCues.defaultCueList
//    			key=RadioButtonMenuItem.acceleratorForeground
//    			key=ToolBar.foreground
//    			key=ToolTip.backgroundInactive
//    			key=Tree.scrollsOnExpand
//    			key=RadioButtonMenuItem.foreground
//    			key=PopupMenuUI
//    			key=ToggleButton.select
//    			key=Slider.shadow
//    			key=MenuUI
//    			key=MenuBar.windowBindings
//    			key=Button.disabledText
//    			key=CheckBoxMenuItem.borderPainted
//    			key=RadioButton.gradient
//    			key=OptionPane.questionDialog.border.background
//    			key=FormattedTextField.background
//    			key=TabbedPane.font
//    			key=RadioButton.font
//    			key=Menu.background
//    			key=ToolTip.font
//    			key=ToolBar.darkShadow
//    			key=Button.font
//    			key=TextPaneUI
//    			key=ToolBar.background
//    			key=EditorPaneUI
//    			key=EditorPane.caretBlinkRate
//    			key=RadioButtonMenuItem.background
//    			key=CheckBoxMenuItem.acceleratorForeground
//    			key=Spinner.editorAlignment
//    			key=MenuBar.foreground
//    			key=RadioButton.border
//    			key=ToolBar.highlight
//    			key=TextAreaUI
//    			key=MenuItemUI
//    			key=RadioButton.shadow
//    			key=InternalFrame.activeTitleGradient
//    			key=RadioButtonMenuItem.commandSound
//    			key=List.dropCellBackground
//    			key=Menu.margin
//    			key=RadioButton.totalInsets
//    			key=SplitPaneDivider.border
//    			key=TextPane.border
//    			key=Slider.minimumHorizontalSize
//    			key=MenuItem.margin
//    			key=EditorPane.background
//    			key=RadioButtonMenuItem.borderPainted
//    			key=InternalFrame.paletteTitleHeight
//    			key=Table.foreground
//    			key=SplitPane.dividerSize
//    			key=TabbedPane.selectedTabPadInsets
//    			key=InternalFrame.inactiveTitleForeground
//    			key=TextPane.caretBlinkRate

    	
    	//////////////////////debug
    	

	}


	class CheckBoxListCellRenderer extends JComponent 
        implements ListCellRenderer {
		
        DefaultListCellRenderer defaultComp;
        
        JCheckBox checkbox;
        
        public CheckBoxListCellRenderer() {
        	
            setLayout (new BorderLayout());
            
            defaultComp = new DefaultListCellRenderer();
            
            checkbox = new JCheckBox();
            
            add (checkbox, BorderLayout.WEST);
            add (defaultComp, BorderLayout.CENTER);
        }

        public Component getListCellRendererComponent(JList list,
                                                      Object  value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus){
            defaultComp.getListCellRendererComponent (list, value, index,
                                                      isSelected, cellHasFocus);
            
            //debug
            System.out.println("list.getName()=" + list.getName());
			System.out.println("isSelected=" + isSelected);
			System.out.println("cellHasFocus=" + cellHasFocus);
			System.out.println("value=" + value);
            
            ///////////////////////////////
            
            /*
            checkbox.setSelected (isSelected);
            checkbox.setForeground (isSelected ?
                                    listSelectionForeground :
                                    listForeground);
            checkbox.setBackground (isSelected ?
                                    listSelectionBackground :
                                    listBackground);
            */
            checkbox.setSelected (isSelected);
            
            Component[] comps = getComponents();
            for (int i=0; i<comps.length; i++) {
                comps[i].setForeground (listForeground);
                comps[i].setBackground (listBackground);
            }
            return this;
        }
    }
}
