package com.sfxcode.sapphire.extension.control

import javafx.scene.control.{Control, Skin}

import com.sfxcode.sapphire.extension.skin.DualDataListViewSkin


class DualDataListView [S<:AnyRef] extends Control {

  val leftDataListView = new DataListView[S]()

  val rightDataListView = new DataListView[S]()


  protected override def createDefaultSkin: Skin[DualDataListView[S]] = {
    new DualDataListViewSkin[S](this)
  }

  def setItems(values:Iterable[S]): Unit = {
    leftDataListView.setItems(values)
    rightDataListView.setItems(List[S]())
  }

  def addLeftFilter() = {
    leftDataListView.addFilter()
  }

  def addRightFilter() = {
    rightDataListView.addFilter()
  }

  def addFilter() ={
    addLeftFilter()
    addRightFilter()
  }



}