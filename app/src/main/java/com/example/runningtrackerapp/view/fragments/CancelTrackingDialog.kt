package com.example.runningtrackerapp.view.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.runningtrackerapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog : DialogFragment() {

    private var stopListener: (() -> Unit)? = null

    fun setStopListener(listener: () -> Unit) {
        stopListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Cancelar carrera")
            .setMessage("Esta seguro de que quiere cancelar su carrera?.")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Si") { _,_ ->
                stopListener?.let { stop ->
                    stop()
                }
            }
            .setNegativeButton("No"){ dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }
}