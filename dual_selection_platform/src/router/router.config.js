export default [
    {
        path: '/',
        name: 'CollegeIndex',
        component: () => import('../views/college/CollegeIndex.vue'),
        children: []
    },
    // {
    //     path: '/',
    //     name: 'InfoRetest',
    //     component: () => import('../views/graduate/InfoRetest.vue'),
    //     children: []
    // },
    {
        path: '/ScoreImport',
        name: 'ScoreImport',
        component: () => import('../views/graduate/ScoreImport.vue'),
        children: []
    },
    {
        path: '/ScoreManage',
        name: 'ScoreManage',
        component: () => import('../views/graduate/ScoreManage.vue'),
        children: []
    },
    {
        path: '/InfoRetest',
        name: 'InfoRetest',
        component: () => import('../views/graduate/InfoRetest.vue'),
        children: []
    },
    {
        path: '/TeacherQuestion',
        name: 'TeacherQuestion',
        component: () => import('../views/graduate/TeacherQuestion.vue'),
        children: []
    },

    {
        path: '/CandidateVolunteer',
        name: 'CandidateVolunteer',
        component: () => import('../views/college/CandidateVolunteer.vue'),
        children: []
    },
    {
        path: '/MentorManagement',
        name: 'MentorManagement',
        component: () => import('../views/college/MentorManagement.vue'),
        children: []
    },
    {
        path: '/MentorQualification',
        name: 'MentorQualification',
        component: () => import('../views/college/MentorQualification.vue'),
        children: []
    },
    {
        path: '/MentorSelection',
        name: 'MentorSelection',
        component: () => import('../views/college/MentorSelection.vue'),
        children: []
    },
    {
        path: '/RecruitmentManagement',
        name: 'RecruitmentManagement',
        component: () => import('../views/college/RecruitmentManagement.vue'),
        children: []
    },
    // {
    //     path: '/addAdmissions',
    //     name: 'AddAdmissions',
    //     component: () => import('../views/college/addAdmissions.vue'),
    //     children: []
    // }
]
