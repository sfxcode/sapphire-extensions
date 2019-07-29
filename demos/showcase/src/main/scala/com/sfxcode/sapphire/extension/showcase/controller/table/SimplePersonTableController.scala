package com.sfxcode.sapphire.extension.showcase.controller.table

import javafx.beans.binding.Bindings
import javafx.fxml.FXML
import javafx.scene.control.TableView

import com.sfxcode.sapphire.core.controller.ViewController
import com.sfxcode.sapphire.core.value.FXBean
import com.sfxcode.sapphire.extension.showcase.model.{ Person, PersonDatabase }

import javafx.collections.ObservableBuffer
import com.sfxcode.sapphire.core.Includes._
import com.sfxcode.sapphire.extension.showcase.controller.MainWindowController
import javafx.Includes._

class SimplePersonTableController extends ViewController {

  @FXML
  var table: TableView[FXBean[Person]] = _

  def testString = "Test"

  override def didGainVisibilityFirstTime(): Unit = {
    super.didGainVisibilityFirstTime()
    val items: ObservableBuffer[FXBean[Person]] = PersonDatabase.smallPersonList
    table.setItems(items)
    mainWindowController.statusBar.textProperty() <== Bindings.format("%d records found", Bindings.size(items))

  }

  def mainWindowController: MainWindowController = {
    parent.asInstanceOf[MainWindowController]
  }
}

