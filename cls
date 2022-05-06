[33mcommit eea11f61fc2c6d8e3dcfb2a87a329c39d099d995[m[33m ([m[1;36mHEAD -> [m[1;32mmain[m[33m, [m[1;31morigin/main[m[33m)[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Fri May 6 12:54:27 2022 -0500

    Generating a report with the notes in a html document

[33mcommit ba7823d1e15d39d4d40ec57eb82a7684086b91f3[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed May 4 12:49:10 2022 -0500

    Added filter option to diplay notes

[33mcommit b83b476c92f17d9ddfdeb15d3225afae80bc7501[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue May 3 18:43:36 2022 -0500

    Added a status load bar for RosterList

[33mcommit feabea7ccc5156dee581db2a97bd66446eb2cfd5[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue May 3 18:28:01 2022 -0500

    Added test for RosterListFragment class

[33mcommit 52fa06987bf40b6ab7a2c564515c7945d5404ee8[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue May 3 17:55:28 2022 -0500

    Tests for ToDoRepository class

[33mcommit 39bc201d2b81273f1294d9a06d26320d83e530f3[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 26 17:37:09 2022 -0500

    Added some tests for SingleModelMotor class

[33mcommit 5af18bb1e07473cb8bd77ba941a63e253e8b9b7f[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Mon Apr 25 18:14:44 2022 -0500

    Added view states to RosterList, Display and Edit classes

[33mcommit 4a80029cf897c06f33d5135a81d40ab34d13a876[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed Apr 20 13:06:09 2022 -0500

    Added dependencies to work with room, created ToDoEntity and ToDoDatabase, changed the ToDoRepository class to work with ToDoEntity. Added all necessary single's in koinModule in ToDoApp

[33mcommit 7c1f244c0fad5e98e4209c07f0dd0bbf2be78507[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed Apr 20 11:50:29 2022 -0500

    Refactor the code adding repo and ui packages

[33mcommit dc01066a1f524b10d0dca5a744f8b41a951ae1fb[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 19 17:33:36 2022 -0500

    Added Delete item functionality

[33mcommit fed9436013f27e6219fb5849b3c767a05fe4a919[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 19 17:21:57 2022 -0500

    Added create new note funcionality

[33mcommit 994276565fbcecfb0002ccf4fde8f851a33f8f7e[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed Apr 13 13:33:58 2022 -0500

    Added: Save functionality

[33mcommit 1262312def7a689ff6d6a1c33a720f6705a58ce7[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed Apr 13 12:45:16 2022 -0500

    Created: EditFragment, it was added to nav graph and its accesible via app bar in DisplayFragment. It also gets description and notes from selected note

[33mcommit 5679c098cda079d7853f7d347252bfe70da38677[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 12 13:56:44 2022 -0500

    Crated: DisplayFragment to show notes detail, added functionality, nav behavior and viewModel motor

[33mcommit 8af4968383a4c627a3138d489702aae678a816b0[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 12 12:02:18 2022 -0500

    Tracking the completion status with save method in ToDoRepository, it was pass as argument from ToDoMotor->RosterListFragment->RosterAdapter->RosterRowHolder.bind() method

[33mcommit 47afba61a4ab84d776b151f651c5dc63bbb42379[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Mon Apr 11 14:14:33 2022 -0500

    Solved: bug when run app caused by androidLogger in ToDoApp. Added: RosterAdapter and RosterRowHolder to populate the recyclerView

[33mcommit 841ab518da4381a23089b555a330231b9239b8dc[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Wed Apr 6 17:32:41 2022 -0500

    Created RosterMotor class to work as ViewModel

[33mcommit 46a11e2cd54b68ca82df04d8175ff02630d9c838[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 5 19:33:19 2022 -0500

    Created ToDoApp and added dependencies to use koin

[33mcommit d472072409a53b17cff6bf826f3e8bc7716d2716[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 5 19:09:21 2022 -0500

    Created ToDoRepository class with dummy data

[33mcommit d66de3adbc281dc18bab7428cc3b2a3a913ea061[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 5 18:54:27 2022 -0500

    Added ToDo model class, and support for java.time classes in android API 21

[33mcommit e80c5b2f21d2d6ddc75885aea0bbe290893b0ae8[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 5 13:41:46 2022 -0500

    Created About activity, for the AboutOption item, and shows an html defined as an asset

[33mcommit e649dab9ed3ab07f0eac2557e411fedc00bdbb83[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Tue Apr 5 13:09:23 2022 -0500

    Actived the binding feature and added the App Bar with a menu and an About option

[33mcommit 3bd6e642fa1703d0996f4c738021ac454c281732[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Fri Apr 1 17:02:01 2022 -0600

    Added dependencies for navigation, created the nav_graph file and new activity_main, also added the FragmentContainerView component in activity_main file

[33mcommit 3ee2fa3cc7c177457f9d331a1aed44328a29d416[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 13:41:06 2022 -0600

    Refactor activity_main.mxl to todo_roster.xml to be used as a fragment. Also RosterListFragment class was created

[33mcommit f4dcdf3b7bf5a07ea89570780ab5150653db6b39[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 13:09:01 2022 -0600

    Added RecyclerView to activity_main.xml file

[33mcommit 31671151a98177456d7630b66fd176f2068a1abb[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 12:54:11 2022 -0600

    Added dependency for recyclerView

[33mcommit 7211683671459cf22fe251c055017d508304885e[m
Merge: 27fbfa2 c6e254c
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 12:41:34 2022 -0600

    Merge branch 'main' of github.com:JoseCruzMV/ToDo

[33mcommit c6e254ccc90a9a954f323ed66d792663f1692038[m
Author: JoseCruzMV <64292495+JoseCruzMV@users.noreply.github.com>
Date:   Thu Mar 31 12:39:25 2022 -0600

    Initial commit

[33mcommit 27fbfa2b3fb8651394f13344c02b3c3e2d373b03[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 12:37:16 2022 -0600

    Set app Icon

[33mcommit 210fd2f3e1a24691c9361544611b4fbc0be79713[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 12:27:07 2022 -0600

    Initial settings in manifest file

[33mcommit 008aa1291d1e21c588281ff16fd7ef1cada2d25d[m
Author: Jose C Morgado Vargas <josecruzmv@outlook.com>
Date:   Thu Mar 31 12:08:03 2022 -0600

    Initial commit
