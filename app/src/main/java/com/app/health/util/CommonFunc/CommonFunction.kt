package com.app.health.util.CommonFunc

import com.app.health.R
import com.app.health.allahname.beans.AllahBeans
import com.app.health.more.model.MoreMenuModel
import com.app.health.re_arrange_today_card.model.Mybeans
import com.app.health.ui.duas.fragment.duascategories.model.DuasBeans
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class CommonFunction() {

    fun getListAll(): ArrayList<String> {
        val list: ArrayList<String> = ArrayList()

        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");


        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");

        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");

        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");

        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");


        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");


        list.add("When Walking up")
        list.add("When wearing a garment");
        list.add("When wearing a new garment");
        list.add("To someone wear a new garment");
        list.add("Before undressing");
        list.add("Before entering the toilet");





        return list

    }

    fun getMoreList(): ArrayList<MoreMenuModel> {
        val list: ArrayList<MoreMenuModel> = ArrayList()


        list.add(
            MoreMenuModel(
                R.drawable.ic_favorite_black_24dp, "Inspiration"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_adjust_black_24dp, "Tracker"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_volume_up_black_24dp, "Shop"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_people_black_24dp, "Community"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_featured_play_list_black_24dp, "Halal"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_menu_black_24dp, "Mosques"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_radio_button_unchecked_black_24dp, "Hajj & " +
                        "Umrah"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_more_horiz_black_24dp, "Holidays"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_date_range_black_24dp, "Calendar"
            )
        )
        list.add(
            MoreMenuModel(
                R.drawable.ic_done_black_24dp, "Messages"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_local_library_black_24dp, "Duas"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_apps_black_24dp, "Shahadah"
            )
        )


        list.add(
            MoreMenuModel(
                R.drawable.ic_chrome_reader_mode_black_24dp, "Zakat"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_menu_black_24dp, "Name"
            )
        )


        list.add(
            MoreMenuModel(
                R.drawable.ic_local_library_black_24dp, "Makkah"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_wb_sunny_black_24dp, "Tasbih"
            )
        )

        list.add(
            MoreMenuModel(
                R.drawable.ic_adjust_black_24dp, "Help"
            )
        )
        return list
    }

    fun getAllTOdayList(): ArrayList<Mybeans> {
        val list: ArrayList<Mybeans> = ArrayList()


        list.add(
            Mybeans(
                "Quran",
                "Verse of the Day"
            )
        )

        list.add(
            Mybeans(
                "Inspiration",
                "Quotes"
            )
        )

        list.add(
            Mybeans(
                "Tips",
                "...."
            )
        )

        list.add(
            Mybeans(
                "Jumma",
                "Prayers"
            )
        )

        list.add(
            Mybeans(
                "Inspiration",
                "Videos"
            )
        )

        list.add(
            Mybeans(
                "Community",
                "...."
            )
        )

        list.add(
            Mybeans(
                "Daus",
                "...."
            )
        )

        list.add(
            Mybeans(
                "Personal Tracker",
                "...."
            )
        )

        list.add(
            Mybeans(
                "Inspiration",
                "Articles"
            )
        )

        list.add(
            Mybeans(
                "Inspiration",
                "Images"
            )
        )

        list.add(
            Mybeans(
                "Names",
                "Messages"
            )
        )

        list.add(
            Mybeans(
                "Share",
                "...."
            )
        )



        return list;
    }

    fun getInspirationListImages(): ArrayList<Int> {
        val mList: ArrayList<Int> = ArrayList();
        mList.add(R.drawable.prayer_background_preview_1)
        mList.add(R.drawable.prayer_background_preview_2)
        mList.add(R.drawable.prayer_background_preview_3)
        mList.add(R.drawable.prayer_background_preview_4)
        mList.add(R.drawable.prayer_background_preview_5)
        mList.add(R.drawable.prayer_background_preview_6)
        mList.add(R.drawable.prayer_background_preview_7)
        mList.add(R.drawable.prayer_background_preview_8)
        mList.add(R.drawable.prayer_background_preview_9)
        mList.add(R.drawable.prayer_background_preview_10)
        mList.add(R.drawable.prayer_background_preview_11)
        mList.add(R.drawable.prayer_background_preview_12)
        mList.add(R.drawable.prayer_background_preview_13)
        mList.add(R.drawable.prayer_background_preview_14)
        mList.add(R.drawable.prayer_background_preview_15)
        mList.add(R.drawable.prayer_background_preview_16)
        mList.add(R.drawable.prayer_background_preview_17)
        mList.add(R.drawable.prayer_background_preview_18)
        mList.add(R.drawable.prayer_background_preview_19)
        mList.add(R.drawable.prayer_background_preview_20)
        mList.add(R.drawable.prayer_background_preview_21)
        mList.add(R.drawable.prayer_background_preview_22)
        mList.add(R.drawable.prayer_background_preview_23)
        mList.add(R.drawable.prayer_background_preview_24)
        mList.add(R.drawable.prayer_background_preview_25)

        return mList
    }

/*
* {"Ar-Rahman", "Ar-Raheem", "Al-Malik", "Al-Quddus", "As-Salam", "Al-Mu min", "Al-Muhaymin", "Al-Aziz",
*  "Al-Jabbar", "Al-Mutakabbir", "Al-Khaaliq", "Al-Baari", "Al-Musawwir", "Al-Ghaffar", "Al-Qahhaar",
* "Al-Wahhaab", "Ar-Razzaaq", "Al-Fattaah", "Al- Alim", "Al-Qaabid", "Al-Basit", "Al-Khaafid",
            "Ar-Raafi", "Al-Mu izz", "Al-Muzil", "As-Sami", "Al-Basir", "Al-Hakam", "Al-Adl",
            *  "Al-Latif", "Al-Khabir", "Al-Halim", "Al- Azim", "Al-Ghafur", "Ash-Shakur",
            * "Al- Ali", "Al-Kabir", "Al-Hafiz", "Al-Muqit", "Al-Hasib", "Al-Jalil",
            * "Al-Karim", "Ar-Raqib", "Al-Mujib",
            "Al-Wasi", "Al-Hakim", "Al-Wadud", "Al-Majeed", "Al-Baa ith", "Ash-Shahid",
            * "Al-Haqq", "Al-Wakil", "Al-Qawiyy", "Al-Matin", "Al-Wali", "Al-Hamid", "Al-Muhsi",
            *  "Al-Mubdi", "Al-Mu id", "Al-Muhyi", "Al-Mumit", "Al-Hayy", "Al-Qayyum", "Al-Waajid",
            * "Al-Maajid", "Al-Waahid",
            "Al-Ahad", "As-Samad", "Al-Qadir", "Al-Muqtadir", "Al-Muqaddim", "Al-Mu akhkhir",
            * "Al-Awwal", "Al-Akhir", "Az-Zahir", "Al-Batin", "Al-Wali", "Al-Muta ali", "Al-Barr",
            * "At-Tawwaab", "Al-Muntaqim", "Al-Afuww", "Ar-Ra uf", "Malik al-Mulk",
            * "Dhu al Jalal wa al Ikram", "Al-Muqsit", "Al-Jami", "Al-Ghani",
            "Al-Mughni", "Al-Mani", "Ad-Darr", "An-Nafi", "An-Nur", "Al-Hadi",
            *  "Al-Badi", "Al-Baaqi", "Al-Waarith", "Ar-Rashid", "As-Sabur"};

    public static String meaning[] = {"The Beneficent", "The Merciful", "The Eternal Lord", "The Most Sacred",
    *  "The Embodiment of Peace", "The Infuser of Faith",
            "The Preserver of Safety", "The Mighty One",
            *  "The Omnipotent One", "The Dominant One",
            *  "The Creator", "The Evolver",
            "The Flawless Shaper", "The Great Forgiver",
            * "The All-Prevailing One", "The Supreme Bestower",
            *  "The Total Provider", "The Supreme Solver",
            "The All-Knowing One", "The Restricting One",
            * "The Extender", "The Reducer", "The Elevating One", "The Honourer-Bestower",
            "The Abaser", "The All-Hearer", "The All-Seeing", "The Impartial Judge", "The Embodiment of Justice", "The Knower of Subtleties",
            "The All-Aware One", "The Clement One", "The Magnificent One", "The Great Forgiver", "The Acknowledging One", "The Sublime One",
            "The Great One", "The Guarding One", "The Sustaining One", "The Reckoning One", "The Majestic One", "The Bountiful One",
            "The Watchful One", "The Responding One", "The All-Pervading One", "The Wise One", "The Loving One", "The Glorious One",
            "The Infuser of New Life", "The All Observing Witness", "The Embodiment of Truth", "The Universal Trustee", "The Strong One", "The Firm One",
            "The Protecting Associate", "The Sole-Laudable One", "The All-Enumerating One", "The Originator", "The Restorer", "The Maintainer of life",
            "The Inflictor of Death", "The Eternally Living One", "The Self-Subsisting One", "The Pointing One", "The All-Noble One", "The Only One",
            "The Sole One", "The Supreme Provider", "The Omnipotent One", "The All Authoritative One", "The Expediting One", "The Procrastinator",
            "The Very First", "The Infinite Last One", "The Perceptible", "The Imperceptible", "The Holder of Supreme Authority", "The Extremely Exalted One",
            "The Fountain-Head of Truth", "The Ever-Acceptor of Repentance", "The Retaliator", "The Supreme Pardoner", "The Benign One", "The Eternal Possessor of Sovereignty",
            "The Possessor of Majesty and Honour", "The Just One", "The Assembler of Scattered Creations", "The Self-Sufficient One", "The Bestower of Sufficiency",
            "The Preventer", "The Distressor", "The Bestower of Benefits", "The Prime Light", "The Provider of Guidance", "The Unique One",
            "The Ever Surviving One", "The Eternal Inheritor", "The Guide to Path of Rectitude", "The Extensively Enduring One"};

    public static String description[] = {"He who wills goodness and mercy for all His creatures",
            "He who acts with extreme kindness",
            "The Sovereign Lord, The One with the complete Dominion, the One Whose Dominion is clear from imperfection",
            "The One who is pure from any imperfection and clear from children and adversaries",
            "The One who is free from every imperfection.",
            "The One who witnessed for Himself that no one is God but Him. And He witnessed for His believers that they are truthful in their belief that no one is God but Him",
            "The One who witnesses the saying and deeds of His creatures",
            "The Strong, The Defeater who is not defeated",
            "The One that nothing happens in His Dominion except that which He willed",
            "The One who is clear from the attributes of the creatures and from resembling them.",
            "The One who brings everything from non-existence to existence",
            "The Maker, The Creator who has the Power to turn the entities.",
            "The One who forms His creatures in different pictures.",
            "The Forgiver, The One who forgives the sins of His slaves time and time again.",
            "The Dominant, The One who has the perfect Power and is not unable over anything.",
            "The One who is Generous in giving plenty without any return. He is everything that benefits whether Halal or Haram.",
            "The Sustainer, The Provider.", "The Opener, The Reliever, The Judge, The One who opens for His slaves the closed worldly and religious matters.",
            "The Knowledgeable; The One nothing is absent from His knowledge",
            "The Constrictor, The Withholder, The One who constricts the sustenance by His wisdom and expands and widens it with His Generosity and Mercy.",
            "The Englarger, The One who constricts the sustenance by His wisdom and expands and widens it with His Generosity and Mercy.",
            "The Abaser, The One who lowers whoever He willed by His Destruction and raises whoever He willed by His Endowment.",
            "The Exalter, The Elevator, The One who lowers whoever He willed by His Destruction and raises whoever He willed by His Endowment.",
            "He gives esteem to whoever He willed, hence there is no one to degrade Him; And He degrades whoever He willed, hence there is no one to give Him esteem.",
            "The Dishonourer, The Humiliator, He gives esteem to whoever He willed, hence there is no one to degrade Him; And He degrades whoever He willed, hence there is no one to give Him esteem.",
            "The Hearer, The One who Hears all things that are heard by His Eternal Hearing without an ear, instrument or organ.",
            "The All-Noticing, The One who Sees all things that are seen by His Eternal Seeing without a pupil or any other instrument.",
            "The Judge, He is the Ruler and His judgment is His Word.",
            "The Just, The One who is entitled to do what He does.",
            "The Subtle One, The Gracious, The One who is kind to His slaves and endows upon them.",
            "The One who knows the truth of things.The Forebearing",
            "The One who delays the punishment for those who deserve it and then He might forgive them",
            "The Great One, The Mighty, The One deserving the attributes of Exaltment, Glory, Extolement, and Purity from all imperfection.",
            "The All-Forgiving, The Forgiving, The One who forgives a lot.",
            "The Grateful, The Appreciative, The One who gives a lot of reward for a little obedience.",
            "The Most High, The One who is clear from the attributes of the creatures.",
            "The Most Great, The Great, The One who is greater than everything in status.",
            "The Preserver, The Protector, The One who protects whatever and whoever He willed to protect.",
            "The Maintainer, The Guardian, The Feeder, The One who has the Power.",
            "The Reckoner, The One who gives the satisfaction.",
            "The Sublime One, The Beneficent, The One who is attributed with greatness of Power and Glory of status.",
            "The Generous One, The Gracious, The One who is attributed with greatness of Power and Glory of status.",
            "The Watcher, The One that nothing is absent from Him. Hence it’s meaning is related to the attribute of Knowledge.",
            "The Responsive, The Hearkener, The One who answers the one in need if he asks Him and rescues the yearner if he calls upon Him.",
            "The Vast, The All-Embracing, The Knowledgeable.",
            "The Wise, The Judge of Judges, The One who is correct in His doings.",
            "The One who loves His believing slaves and His believing slaves love Him. His love to His slaves is His Will to be merciful to them and praise them",
            "The Most Glorious One, The One who is with perfect Power, High Status, Compassion, Generosity and Kindness.",
            "The Resurrector, The Raiser (from death), The One who resurrects His slaves after death for reward and/or punishment.",
            "The Witness, The One who nothing is absent from Him.", "The Truth, The True, The One who truly exists.",
            "The Trustee, The One who gives the satisfaction and is relied upon.",
            "The Most Strong, The Strong, The One with the complete Power",
            "The One with extreme Power which is un-interrupted and He does not get tired.",
            "The Protecting Friend, The Supporter.",
            "The Praiseworthy, The praised One who deserves to be praised.",
            "The Counter, The Reckoner, The One who the count of things are known to him.",
            "The One who started the human being. That is, He created him.",
            "The Reproducer, The One who brings back the creatures after death",
            "The Restorer, The Giver of Life, The One who took out a living human from semen that does not have a soul. He gives life by giving the souls back to the worn out bodies on the resurrection day and He makes the hearts alive by the light of knowledge.",
            "The Creator of Death, The Destroyer, The One who renders the living dead.",
            "The Alive, The One attributed with a life that is unlike our life and is not that of a combination of soul, flesh or blood.",
            "The One who remains and does not end.",
            "The Perceiver, The Finder, The Rich who is never poor. Al-Wajd is Richness.",
            "The Glorious, He who is Most Glorious.",
            "The Unique, The One, The One without a partner",
            "The One",
            "The Eternal, The Independent, The Master who is relied upon in matters and reverted to in ones needs.",
            "The Able, The Capable, The One attributed with Power.",
            "The Powerful, The Dominant, The One with the perfect Power that nothing is withheld from Him.",
            "The Expediter, The Promoter, The One who puts things in their right places. He makes ahead what He wills and delays what He wills.",
            "The Delayer, the Retarder, The One who puts things in their right places. He makes ahead what He wills and delays what He wills.",
            "The First, The One whose Existence is without a beginning.",
            "The Last, The One whose Existence is without an end.",
            "The Manifest, The One that nothing is above Him and nothing is underneath Him, hence He exists without a place. He, The Exalted, His Existence is obvious by proofs and He is clear from the delusions of attributes of bodies.",
            "The Hidden, The One that nothing is above Him and nothing is underneath Him, hence He exists without a place. He, The Exalted, His Existence is obvious by proofs and He is clear from the delusions of attributes of bodies.",
            "The Governor, The One who owns things and manages them.",
            "The Most Exalted, The High Exalted, The One who is clear from the attributes of the creation.",
            "The Source of All Goodness, The Righteous, The One who is kind to His creatures, who covered them with His sustenance and specified whoever He willed among them by His support, protection, and special mercy.",
            "The Relenting, The One who grants repentance to whoever He willed among His creatures and accepts his repentance.",
            "The Avenger, The One who victoriously prevails over His enemies and punishes them for their sins. It may mean the One who destroys them.",
            "The Forgiver, The One with wide forgiveness.",
            "The Compassionate, The One with extreme Mercy. The Mercy of Allah is His will to endow upon whoever He willed among His creatures.",
            "The One who controls the Dominion and gives dominion to whoever He willed.",
            "The Lord of Majesty and Bounty, The One who deserves to be Exalted and not denied.",
            "The Equitable, The One who is Just in His judgment.",
            "The Gatherer, The One who gathers the creatures on a day that there is no doubt about, that is the Day of Judgment.",
            "The One who does not need the creation.",
            "The Enricher, The One who satisfies the necessities of the creatures.",
            "The Withholder.",
            "The One who makes harm reach to whoever He willed and benefit to whoever He willed.",
            "The Propitious, The One who makes harm reach to whoever He willed and benefit to whoever He willed.",
            "The Light, The One who guides.",
            "The Guide, The One whom with His Guidance His believers were guided, and with His Guidance the living beings have been guided to what is beneficial for them and protected from what is harmful to them.",
            "The Incomparable, The One who created the creation and formed it without any preceding example.",
            "The Everlasting, The One that the state of non-existence is impossible for Him.",
            "The Heir, The One whose Existence remains.",
            "The Guide to the Right Path, The One who guides.",
            "The Patient, The One who does not quickly punish the sinners."};
*
* */
    fun getListOfAllahName(): ArrayList<AllahBeans> {
        val mList: ArrayList<AllahBeans> = ArrayList()

        mList.add(
            AllahBeans(
                R.drawable.a0,
                "Ar-Rahman",
                "The Beneficent",
                "He who wills goodness and mercy for all His creatures"
            )
        )


    mList.add(
        AllahBeans(
            R.drawable.a1,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )

    mList.add(
        AllahBeans(
            R.drawable.a2,
            "Ar-Raheem",
            "The Merciful, The Eternal Lord",
            "He who acts with extreme kindness"
        )
    )

    mList.add(
        AllahBeans(
            R.drawable.a3,
            "Al-Malik",
            "The Eternal Lord",
            "The Sovereign Lord, The One with the complete Dominion, the One Whose Dominion is clear from imperfection"
        )
    )

    mList.add(
        AllahBeans(
            R.drawable.a4,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a5,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a6,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a7,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a8,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a9,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a10,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a11,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a12,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a13,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a14,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )
    mList.add(
        AllahBeans(
            R.drawable.a15,
            "Ar-Rahman",
            "The Beneficent",
            "He who wills goodness and mercy for all His creatures"
        )
    )

        return mList
    }

    fun getDatbroadList(): ArrayList<DuasBeans> {
        val list: ArrayList<DuasBeans> = ArrayList();


        list.add(
            DuasBeans(
                R.drawable.ic_account_circle_black_24dp,
                "All",
                "132 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Morning and Evening",
                "6 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_date_range_black_24dp,
                "Home & Family",
                "14 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Food & Drink",
                "7 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_menu_black_24dp,
                "Joy & Distress",
                "15 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_share_black_24dp,
                "Travel",
                "11 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Prayer",
                "19 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_favorite_black_24dp,
                "Praising Allah",
                "9 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Hajj & Umrah",
                "8 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Good Etiquette",
                "20 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Nature",
                "10 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Sickness & Death",
                "13 Chapter"
            )
        )

        list.add(
            DuasBeans(
                R.drawable.ic_account_circle_black_24dp,
                "All",
                "132 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Morning and Evening",
                "6 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_date_range_black_24dp,
                "Home & Family",
                "14 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Food & Drink",
                "7 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_menu_black_24dp,
                "Joy & Distress",
                "15 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_share_black_24dp,
                "Travel",
                "11 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_format_align_justify_black_24dp,
                "Prayer",
                "19 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_favorite_black_24dp,
                "Praising Allah",
                "9 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Hajj & Umrah",
                "8 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Good Etiquette",
                "20 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Nature",
                "10 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Sickness & Death",
                "13 Chapter"
            )
        )

        list.add(
            DuasBeans(
                R.drawable.ic_account_circle_black_24dp,
                "All",
                "132 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Morning and Evening",
                "6 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_date_range_black_24dp,
                "Home & Family",
                "14 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Food & Drink",
                "7 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_menu_black_24dp,
                "Joy & Distress",
                "15 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_share_black_24dp,
                "Travel",
                "11 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Prayer",
                "19 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_favorite_black_24dp,
                "Praising Allah",
                "9 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Hajj & Umrah",
                "8 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Good Etiquette",
                "20 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Nature",
                "10 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Sickness & Death",
                "13 Chapter"
            )
        )


        list.add(
            DuasBeans(
                R.drawable.ic_account_circle_black_24dp,
                "All",
                "132 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Morning and Evening",
                "6 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_date_range_black_24dp,
                "Home & Family",
                "14 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Food & Drink",
                "7 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_menu_black_24dp,
                "Joy & Distress",
                "15 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_share_black_24dp,
                "Travel",
                "11 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_format_align_justify_black_24dp,
                "Prayer",
                "19 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_favorite_black_24dp,
                "Praising Allah",
                "9 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_chrome_reader_mode_black_24dp,
                "Hajj & Umrah",
                "8 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_featured_play_list_black_24dp,
                "Good Etiquette",
                "20 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Nature",
                "10 Chapter"
            )
        )
        list.add(
            DuasBeans(
                R.drawable.ic_mic_black_24dp,
                "Sickness & Death",
                "13 Chapter"
            )
        )
        return list;
    }

    fun postConnectWithOutSll(url: String?): String? {
        var sb: StringBuilder? = null
        val urlW: URL
        var urlConnection: HttpURLConnection? = null
        var line: String?
        var br: BufferedReader? = null
        try {
            urlW = URL(url)
            urlConnection = urlW.openConnection() as HttpURLConnection
            val responseCode = urlConnection.responseCode

            if (responseCode == HttpURLConnection.HTTP_OK) {

                br = BufferedReader(InputStreamReader(urlConnection.inputStream))
                sb = StringBuilder()

                while (br.readLine().also { line = it } != null) {
                    sb.append(line)
                }
                return sb.toString()
            }
        } catch (e: IOException) {
            return e.message

        }
        return sb.toString()
    }
}