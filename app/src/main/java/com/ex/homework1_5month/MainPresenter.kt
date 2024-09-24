package com.ex.homework1_5month

class MainPresenter {

    private val model = CounterModel()
    private var contract:CounterView? = null

    fun attachContract(contract:CounterView){
        this.contract = contract
        contract.showResult(model.count)


    }

    fun onIncrement(){
      model.increment()
        contract?.showResult(model.count)
        chekaem()


    }
    fun onDecrement(){
        model.decrement()
        contract?.showResult(model.count)
        chekaem()

    }

    private fun chekaem(){
        if (model.isOver10()){
            contract?.showMessage("Поздравляем")
        }
        if (model.isOver15()){
            contract?.changeColor(R.color.green)
        }

    }


    fun detachContract(){
        contract = null
    }



}