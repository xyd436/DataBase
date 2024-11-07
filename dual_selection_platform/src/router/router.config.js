export default [
    {
        path: '/',
        name: 'index',
        component: () => import('../views/Index/Index.vue'),
        children:[]
    }
    // {
    //     path: '/knowledgeGraph',
    //     name: 'knowledgeGraph',
    //     component: () => import('../views/KnowledgeGraph/KnowledgeGraph.vue'),
    // },
    // {
    //     path: '/knowledgeGraph/:entityName',
    //     name: 'knowledgeGraphWithParam',
    //     component: () => import('../views/KnowledgeGraph/KnowledgeGraph.vue'),
    // },
    // {
    //     path: '/knowledgeImport',
    //     name: 'knowledgeImport',
    //     component: () => import('../views/KnowledgeImport/KnowledgeImport.vue'),
    // },
    // {
    //     path: '/knowledgeEdit',
    //     name: 'knowledgeEdit',
    //     component: () => import('../views/KnowledgeImport/KnowledgeEdit.vue'),
    // }
]