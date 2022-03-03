package com.example.anadolusigortaciro.ui.home.insuranceservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anadolusigortaciro.R
import com.example.anadolusigortaciro.databinding.FragmentInsuranceServiceBinding
import com.example.anadolusigortaciro.model.InsuranceServiceModel

class InsuranceServiceFragment : Fragment() {
    private lateinit var binding: FragmentInsuranceServiceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInsuranceServiceBinding.inflate(inflater, container, false)

        val insuranceServiceModel = InsuranceServiceModel(
            resources.getString(R.string.bireysel_cati_tipi),
            R.drawable.bireysel_cati_tipi,
            resources.getString(R.string.bireysel_cati_tipi_detail)
        )
        val insuranceServiceModel2 = InsuranceServiceModel(
            resources.getString(R.string.devlet_destekli_tarim_sigortasi),
            R.drawable.devlet_destekli_tarim_sigortasi,
            resources.getString(R.string.devlet_destekli_tarim_sigortasi_detail)
        )
        val insuranceServiceModel3 = InsuranceServiceModel(
            resources.getString(R.string.tibbi_kotu_uygulamaya_iliskin_zorunlu_mali_sorumluluk_sigortasi),
            R.drawable.tibbi_kotu_uygulama,
            resources.getString(R.string.tibbi_kotu_uygulamaya_iliskin_zorunlu_mali_sorumluluk_sigortasi_detail)
        )
        val insuranceServiceModel4 = InsuranceServiceModel(
            resources.getString(R.string.hukuksal_koruma_sigortası),
            R.drawable.hes_menu,
            resources.getString(R.string.hukuksal_koruma_sigortası_detail)
        )
        val insuranceServiceModel5 = InsuranceServiceModel(
            resources.getString(R.string.ozel_guvenlik_zorunlu_mali_sorumluluk_sigortasi),
            R.drawable.ozel_guvenlik_zorulu_mali,
            resources.getString(R.string.ozel_guvenlik_zorunlu_mali_sorumluluk_sigortasi_detail)
        )
        val insuranceServiceModel6 = InsuranceServiceModel(
            resources.getString(R.string.telefonum_guvende),
            R.drawable.telefonum_guvende,
            resources.getString(R.string.telefonum_guvende_detail)
        )
        val insuranceServiceModel7 = InsuranceServiceModel(
            resources.getString(R.string.isveren_zorunluluk_sigortalari),
            R.drawable.isveren_sorumluluk_sigortasi,
            resources.getString(R.string.isveren_sorumluluk_sigortlari_detail)
        )
        val insuranceServiceModel8 = InsuranceServiceModel(
            resources.getString(R.string.yolcu_zorunluluk_sigortalari),
            R.drawable.yolcu_sorumluluk_sigortalari,
            resources.getString(R.string.yolcu_zorunluk_sigortalari_detail)
        )
        val insuranceServiceList = listOf<InsuranceServiceModel>(
            insuranceServiceModel,
            insuranceServiceModel2,
            insuranceServiceModel3,
            insuranceServiceModel4,
            insuranceServiceModel5,
            insuranceServiceModel6,
            insuranceServiceModel7,
            insuranceServiceModel8
        )
        setRecyclerViewAdapter(insuranceServiceList)

        return binding.root
    }

    private fun setRecyclerViewAdapter(insuranceServiceList: List<InsuranceServiceModel>) {
        val mLayoutManager = LinearLayoutManager(context)
        binding.recyclerViewInsuranceService.layoutManager = mLayoutManager
        binding.recyclerViewInsuranceService.adapter = context?.let {
            InsuranceServicesAdapter(
                it,
                insuranceServiceList,
                object : InsuranceServicesAdapter.OnInsuranceServiceClickListener {
                    override fun onClick(position: Int) {
                        //val action = InsuranceServiceFragmentDirections.actionInsuranceServiceFragmentToInsuranceServiceDetailFragment(insuranceServiceList[position])
                        findNavController().navigate(R.id.action_insuranceServiceFragment_to_insuranceServiceDetailFragment)
                    }
                })
        }
    }
}